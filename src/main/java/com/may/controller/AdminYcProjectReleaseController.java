package com.may.controller;

import com.github.pagehelper.PageHelper;
import com.may.common.utils.BeanUtils;
import com.may.controller.model.ReleaseModel;
import com.may.controller.model.RootDirectoriesModel;
import com.may.mybatis.dao.KeyVallueConfigMapper;
import com.may.mybatis.dao.ReleaseListMapper;
import com.may.mybatis.dao.RootDirectoriesMapper;
import com.may.mybatis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by mayxys on 2016/7/10.
 */
@Controller
public class AdminYcProjectReleaseController {
    @Autowired
    private RootDirectoriesMapper rootDirectoriesMapper;
    @Autowired
    private ReleaseListMapper releaseListMapper;

    @Autowired
    private KeyVallueConfigMapper keyVallueConfigMapper;

    private static final int defaultPageSize = 10;
    @RequestMapping(value = "/rootDirectories")
    public String toRootDirectoriesShowPage(){
        return "rootDirectoriesShow.html";
    }
    @RequestMapping(value = "/rootDirectoriesListPage")
    @ResponseBody
    public Map<String, Object> rootDirectoriesListPage(String pageNum, String pageSize) throws InvocationTargetException, IllegalAccessException {
        int num = 1;
        if(!StringUtils.isEmpty(pageNum)){
            num=Integer.parseInt(pageNum);
        }
        if(StringUtils.isEmpty(pageSize)){
            pageSize=String.valueOf(defaultPageSize);
        }
        PageHelper.startPage(num,Integer.parseInt(pageSize));
        RootDirectoriesExample example = new RootDirectoriesExample();
        RootDirectoriesExample.Criteria criteria = example.createCriteria();
        criteria.andIsusedEqualTo("1");
        example.setOrderByClause("create_date desc, id asc");
        List<RootDirectoriesModel>  rootDirectoriesModelList = new ArrayList<RootDirectoriesModel>();
        List<RootDirectories> rootDirectoriesList = rootDirectoriesMapper.selectByExample(example);
        if(null != rootDirectoriesList && !rootDirectoriesList.isEmpty()){
            for (RootDirectories rootDirectories:rootDirectoriesList){
                RootDirectoriesModel rootDirectoriesModel = new RootDirectoriesModel();
                BeanUtils.copyProperties(rootDirectoriesModel,rootDirectories);
                rootDirectoriesModelList.add(rootDirectoriesModel);
            }
        }
        int totalCount = rootDirectoriesMapper.countByExample(example);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("rootDirectoriesList",rootDirectoriesModelList);
        return map;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String saveRootDirectories(String sysId,String directorieyName){
        String returnCode = "000000";
        if(StringUtils.isEmpty(sysId)){
            return returnCode;
        }
        if(StringUtils.isEmpty(directorieyName)){
            return returnCode;
        }
        RootDirectories record = new RootDirectories();
        record.setSysId(sysId);
        record.setDirectorieyName(directorieyName);
        record.setCreateDate(new Date());
        record.setCreatePersion("Admin");
        rootDirectoriesMapper.insertSelective(record);
        return "111111";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRootDirectories")
    public Map<String,String>  deleteRootDirectories(String id){
        Map<String,String> resultMap = new HashMap<String,String>();
        if(StringUtils.isEmpty(id)){
            resultMap.put("returnCode","000000");
            resultMap.put("returnMessage","id不能为空");
            return resultMap;
        }
        RootDirectories record = new RootDirectories();
        record.setIsused("0");
        RootDirectoriesExample example = new RootDirectoriesExample();
        RootDirectoriesExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(id));
        rootDirectoriesMapper.updateByExampleSelective(record,example);
        resultMap.put("returnCode","111111");
        resultMap.put("returnMessage","success");
        return resultMap;
    }

    @RequestMapping(value = "/toAdminFilePathListShow")
    public String toAdminFilePathListShow(){
        return "adminFilePathListShow.html";
    }


    @RequestMapping(value = "/adminFilePathListPage")
    @ResponseBody
    public Map<String, Object> adminFilePathListPage(String pageNum, String pageSize) throws InvocationTargetException, IllegalAccessException {
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
        List<ReleaseList> releaseListWithBLOBs= releaseListMapper.selectByExampleWithBLOBs(releaseListExample);
        List<ReleaseModel> releaseModelList = new ArrayList<ReleaseModel>();
        if(null != releaseListWithBLOBs && !releaseListWithBLOBs.isEmpty()){
            for(ReleaseList release:releaseListWithBLOBs){
                ReleaseModel releaseMode = new ReleaseModel();
                BeanUtils.copyProperties(releaseMode,release);
                releaseModelList.add(releaseMode);
            }
        }
        int totalCount = releaseListMapper.countByExample(releaseListExample);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("releaseListWithBLOBs",releaseModelList);
        return map;
    }

    @RequestMapping(value = "/endPublish")
    @ResponseBody
    public String endPublish(){
        ReleaseListWithBLOBs record = new ReleaseListWithBLOBs();
        record.setIspublish("1");
        record.setIsused("1");
        ReleaseListExample example = new ReleaseListExample();
        ReleaseListExample.Criteria criteria = example.createCriteria();
        criteria.andIsusedEqualTo("1");
        releaseListMapper.updateByExampleSelective(record,example);

        KeyVallueConfig recordKeyVallueConfig = new KeyVallueConfig();
        recordKeyVallueConfig.setRvalue("1");
        recordKeyVallueConfig.setUpdateDate(new Date());
        KeyVallueConfigExample keyVallueConfigExample = new KeyVallueConfigExample();
        KeyVallueConfigExample.Criteria criteriaKeyVallueConfigExample =keyVallueConfigExample.createCriteria();
        criteriaKeyVallueConfigExample.andRkeyEqualTo("endendPublish");
        criteriaKeyVallueConfigExample.andIsusedEqualTo("1");
        keyVallueConfigMapper.updateByExampleSelective(recordKeyVallueConfig,keyVallueConfigExample);

        return "111111";
    }

    @RequestMapping(value = "/startPublish")
    @ResponseBody
    public String startPublish(){
        KeyVallueConfig recordKeyVallueConfig = new KeyVallueConfig();
        recordKeyVallueConfig.setRvalue("0");
        recordKeyVallueConfig.setUpdateDate(new Date());
        KeyVallueConfigExample keyVallueConfigExample = new KeyVallueConfigExample();
        KeyVallueConfigExample.Criteria criteriaKeyVallueConfigExample =keyVallueConfigExample.createCriteria();
        criteriaKeyVallueConfigExample.andRkeyEqualTo("endendPublish");
        criteriaKeyVallueConfigExample.andIsusedEqualTo("1");
        keyVallueConfigMapper.updateByExampleSelective(recordKeyVallueConfig,keyVallueConfigExample);
        return "111111";
    }

}
