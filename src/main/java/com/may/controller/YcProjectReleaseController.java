package com.may.controller;

import com.github.pagehelper.PageHelper;
import com.may.common.utils.BeanUtils;
import com.may.common.utils.DateUtil;
import com.may.controller.model.ReleaseModel;
import com.may.mybatis.dao.*;
import com.may.mybatis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * Created by mayxys on 2016/6/29.
 */
@Controller
public class YcProjectReleaseController {
    private static final int defaultPageSize = 10;
    private static final String RETURNCODE_FAIL = "000000";
    private static final String RETURNCODE_SUCCESS = "111111";
    @Autowired
    private ReleaseListMapper releaseListMapper;
    @Autowired
    private ReleasePersonMapper releasePersonMapper;

    @Autowired
    private RootDirectoriesMapper rootDirectoriesMapper;

    @Autowired
    private ReleaseSystemMapper releaseSystemMapper;
    @Autowired
    private ReleaseSystemPersonMapper releaseSystemPersonMapper;

    @Autowired
    private KeyVallueConfigMapper keyVallueConfigMapper;

    @RequestMapping(value = {"/release"},method = RequestMethod.GET)
    public String toReleaseList(){
        return "releaseList.html";
    }

    @RequestMapping(value = "/saveReleaseList")
    @ResponseBody
    public Map<String,String>  saveReleaseList(ReleaseModel releaseModel) throws InvocationTargetException, IllegalAccessException {
        String returnMessage="";
        String  returnCode = "";
        Map<String,String> returnMap = checkReleaseList(releaseModel);
        if(null != returnMap && RETURNCODE_FAIL.equals(returnMap.get("returnCode"))){
            return returnMap;
        }

        ReleaseListWithBLOBs releaseListWithBLOBs = new ReleaseListWithBLOBs();
        BeanUtils.copyProperties(releaseListWithBLOBs,releaseModel);
        releaseListWithBLOBs.setSystemname(releaseModel.getSystemname());
        releaseListWithBLOBs.setCreateperson(releaseModel.getCreateperson());
        releaseListWithBLOBs.setCreatedate(new Date());
        releaseListWithBLOBs.setPathlist(releaseModel.getPathlist());
        releaseListWithBLOBs.setReleaseMark(releaseModel.getReleaseMark());
        releaseListWithBLOBs.setIsused("1");
        releaseListWithBLOBs.setIspublish("0");
        releaseListMapper.insert(releaseListWithBLOBs);
        returnCode= RETURNCODE_SUCCESS;
        returnMessage="success";
        returnMap.put("returnCode",returnCode);
        returnMap.put("returnMessage",returnMessage);
        return returnMap;
    }
    @RequestMapping(value = "/releasePersonList")
    @ResponseBody
    public List<ReleasePerson> getReleasePerson(String systemId){
        if(StringUtils.isEmpty(systemId)){
            return null;
        }
        List<ReleasePerson> releasePersonList = new ArrayList<ReleasePerson>();
        ReleaseSystemPersonExample releaseSystemPersonExample = new ReleaseSystemPersonExample();
        ReleaseSystemPersonExample.Criteria criteriaReleaseSystemPersonExample = releaseSystemPersonExample.createCriteria();
        criteriaReleaseSystemPersonExample.andReleasesystemidEqualTo(Integer.parseInt(systemId));
        List<ReleaseSystemPerson> releaseSystemPersonList =releaseSystemPersonMapper.selectByExample(releaseSystemPersonExample);
        if(null != releaseSystemPersonList && !releaseSystemPersonList.isEmpty()){
            for(ReleaseSystemPerson releaseSystemPerson:releaseSystemPersonList){
                int releasepersonid = releaseSystemPerson.getReleasepersonid();
                ReleasePersonExample releasePersonExample = new ReleasePersonExample();
                ReleasePersonExample.Criteria CriteriaReleasePerson = releasePersonExample.createCriteria();
                CriteriaReleasePerson.andIdEqualTo(releasepersonid);
                CriteriaReleasePerson.andIsusedEqualTo("1");
                releasePersonList.addAll(releasePersonMapper.selectByExampleWithBLOBs(releasePersonExample));
            }
        }
        return releasePersonList;
    }

    @RequestMapping(value = {"/List","/"})
    public String topeleasePathList(){
       return "releaseListShow.html";
    }


    @RequestMapping(value = "/pathList")
    @ResponseBody
    public List<ReleaseList> peleasePathList(){
        PageHelper.startPage(1,defaultPageSize);
        ReleaseListExample releaseListExample = new ReleaseListExample();
        List<ReleaseList> releaseList = releaseListMapper.selectByExampleWithBLOBs(releaseListExample);
        return releaseList;
    }

    @RequestMapping(value = "/releasePersonListPage")
    @ResponseBody
    public Map<String, Object> releasePersonListPage(String pageNum, String pageSize) throws InvocationTargetException, IllegalAccessException {
        int num = 1;
        if(!StringUtils.isEmpty(pageNum)){
            num=Integer.parseInt(pageNum);
        }
        if(!StringUtils.isEmpty(pageSize)){
            pageSize=String.valueOf(defaultPageSize);
        }
        PageHelper.startPage(num,Integer.parseInt(pageSize));
        ReleaseListExample releaseListExample = new ReleaseListExample();
        ReleaseListExample.Criteria criteria  = releaseListExample.createCriteria();
        criteria.andIsusedEqualTo("1");
        releaseListExample.setOrderByClause("createDate desc");
        List<ReleaseList>  releaseList= releaseListMapper.selectByExampleWithBLOBs(releaseListExample);
        List<ReleaseModel> releaseModelList = new ArrayList<ReleaseModel>();
        if(null != releaseList && !releaseList.isEmpty()){
            for(ReleaseList release:releaseList){
                ReleaseModel releaseMode = new ReleaseModel();
                BeanUtils.copyProperties(releaseMode,release);

                if(!StringUtils.isEmpty(release.getIspublish()) && "1".equals(release.getIspublish())){
                    releaseMode.setIsDelete("0");
                }else{
                    Date createdate  = release.getCreatedate();
                    Date startDate = DateUtil.getStartDate();
                    if(createdate.compareTo(startDate)>-1){
                        releaseMode.setIsDelete("1");
                    }else{
                        releaseMode.setIsDelete("0");
                    }
                }
                releaseMode.setPathlist(releaseMode.getPathlist().replaceAll("\n","<br />"));

                ReleasePersonExample releasePersonExample = new ReleasePersonExample();
                ReleasePersonExample.Criteria criteriaReleasePersonExample = releasePersonExample.createCriteria();
                criteriaReleasePersonExample.andIdEqualTo(Integer.parseInt(releaseMode.getCreateperson()));
                List<ReleasePerson> releasePersonList= releasePersonMapper.selectByExampleWithBLOBs(releasePersonExample);
                if(null != releasePersonList && !releasePersonList.isEmpty()){
                    releaseMode.setCreatepersonName(releasePersonList.get(0).getReleasename());
                }
                releaseModelList.add(releaseMode);
            }
        }
        int totalCount = releaseListMapper.countByExample(releaseListExample);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("releaseListWithBLOBs",releaseModelList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFile")
    public Map<String,String> removeFile(String fileId){
        Map<String,String> resultMap = new HashMap<String, String>();
        if(StringUtils.isEmpty(fileId)){
            resultMap.put("returnCode","000000");
            resultMap.put("returnMessage","参数无效");
            return resultMap;
        }
        ReleaseListExample exampleCount = new ReleaseListExample();
        ReleaseListExample.Criteria  exampleCountCriteria = exampleCount.createCriteria();
        exampleCountCriteria.andIdEqualTo(Integer.parseInt(fileId));
        exampleCountCriteria.andIspublishEqualTo("0");
        exampleCountCriteria.andCreatedateGreaterThan(DateUtil.getStartDate());
        int count = releaseListMapper.countByExample(exampleCount);
        if(count<1){
            resultMap.put("returnCode","000000");
            resultMap.put("returnMessage","参数有误");
            return resultMap;
        }
        ReleaseListWithBLOBs record = new ReleaseListWithBLOBs();
        record.setIsused("0");
        ReleaseListExample example = new ReleaseListExample();
        ReleaseListExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(fileId));
        releaseListMapper.updateByExampleSelective(record,example);
        resultMap.put("returnCode","111111");
        resultMap.put("returnMessage","success");
        return resultMap;
    }

    private Map<String,String> checkReleaseList(ReleaseModel releaseModel){
        Map<String,String> returnMap = new HashMap<String, String>();
        String returnMessage="";
        String  returnCode = "";
        String  createperson = releaseModel.getCreateperson();
        if(StringUtils.isEmpty(createperson)){
            returnCode=RETURNCODE_FAIL;
            returnMessage="发布人不能为空";
            returnMap.put("returnCode",returnCode);
            returnMap.put("returnMessage",returnMessage);
            return returnMap;
        }
        if (StringUtils.isEmpty(releaseModel.getPathlist())){
            returnCode=RETURNCODE_FAIL;
            returnMessage="发布文件不能为空";
            returnMap.put("returnCode",returnCode);
            returnMap.put("returnMessage",returnMessage);
            return returnMap;
        }
        if (StringUtils.isEmpty(releaseModel.getReleaseMark())){
            returnCode=RETURNCODE_FAIL;
            returnMessage="发布说明不为空";
            returnMap.put("returnCode",returnCode);
            returnMap.put("returnMessage",returnMessage);
            return returnMap;
        }
        RootDirectoriesExample  rootDirectoriesExample = new RootDirectoriesExample();
        String[] pathArray = releaseModel.getPathlist().split("\n");

        RootDirectoriesExample.Criteria criteria = rootDirectoriesExample.createCriteria();
        criteria.andIsusedEqualTo("1");
        List<RootDirectories> rootDirectoriesList = rootDirectoriesMapper.selectByExample(rootDirectoriesExample);

        for(String path:pathArray){
            if(path.startsWith("/") || path.startsWith("\\")){
                returnMap.put("returnCode",RETURNCODE_FAIL);
                returnMap.put("returnMessage","路径不符合规范:不能已/或\\开头");
                return returnMap;
            }
            boolean isExist = false;
            if(null != rootDirectoriesList && !rootDirectoriesList.isEmpty()){
                for(RootDirectories rootDirectories :rootDirectoriesList ){
                    if(path.startsWith(rootDirectories.getDirectorieyName())){
                        isExist=true;
                    }
                }
            }
            if(!isExist){
                returnMap.put("returnCode",RETURNCODE_FAIL);
                returnMap.put("returnMessage","路径不符合规范:["+path+"]");
                return returnMap;
            }
        }
        return returnMap;
    }

    @RequestMapping(value = "/releaseSystemlist")
    @ResponseBody
    public List<ReleaseSystem> getReleaseSystem(){
        ReleaseSystemExample example = new ReleaseSystemExample();
        example.setOrderByClause("create_date desc ");
        ReleaseSystemExample.Criteria criteria = example.createCriteria();
        criteria.andIsUsedEqualTo("1");
        List<ReleaseSystem> releaseSystemList = releaseSystemMapper.selectByExample(example);
        return releaseSystemList;
    }

    @RequestMapping(value = "/comfirmIsEnd")
    @ResponseBody
    public String comfirmIsEnd(){
        if(isend()){
            return "111111";
        }else{
            return "000000";
        }
    }


    /**
     *
     * @return  true 截止返回
     */
    private boolean isend(){
        KeyVallueConfigExample keyVallueConfigExample = new KeyVallueConfigExample();
        KeyVallueConfigExample.Criteria criteriaKeyVallueConfigExample = keyVallueConfigExample.createCriteria();
        criteriaKeyVallueConfigExample.andRkeyEqualTo("endendPublish");
        List<KeyVallueConfig> keyVallueConfigList = keyVallueConfigMapper.selectByExample(keyVallueConfigExample);
        if (null == keyVallueConfigList || keyVallueConfigList.isEmpty()){
            return false;
        }
        KeyVallueConfig keyVallueConfig = keyVallueConfigList.get(0);
        String value = keyVallueConfig.getRvalue();
        if("1".equals(value)){
            return true;
        }else{
            return  false;
        }
    }
}
