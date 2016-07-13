package com.may.controller;

import com.github.pagehelper.PageHelper;
import com.may.common.utils.BeanUtils;
import com.may.controller.model.ReleasePersonModel;
import com.may.mybatis.dao.ReleasePersonMapper;
import com.may.mybatis.dao.ReleaseSystemMapper;
import com.may.mybatis.dao.ReleaseSystemPersonMapper;
import com.may.mybatis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by mayxys on 2016/7/13.
 */
@Controller
public class ReleasePersonController {
    @Autowired
    private ReleasePersonMapper releasePersonMapper;
    @Autowired
    private ReleaseSystemMapper releaseSystemMapper;
    @Autowired
    private ReleaseSystemPersonMapper releaseSystemPersonMapper;
    private static final int defaultPageSize = 10;

    @RequestMapping(value = "/toReleasePersonPage")
    public String toReleasePersonPage(){
        return "releasePersonShow.html";
    }

    @RequestMapping(value = "/personListPage")
    @ResponseBody
    public Map<String, Object> personListPage(String pageNum, String pageSize) throws InvocationTargetException, IllegalAccessException {
        int num = 1;
        if(!StringUtils.isEmpty(pageNum)){
            num=Integer.parseInt(pageNum);
        }
        if(StringUtils.isEmpty(pageSize)){
            pageSize=String.valueOf(defaultPageSize);
        }
        PageHelper.startPage(num,Integer.parseInt(pageSize));
        ReleasePersonExample example = new ReleasePersonExample();
        ReleasePersonExample.Criteria criteria = example.createCriteria();
        criteria.andIsusedEqualTo("1");
        example.setOrderByClause("createDate desc, id asc");
        List<ReleasePersonModel> releasePersonModels = new ArrayList<ReleasePersonModel>();
        List<ReleasePerson> rootDirectoriesList = releasePersonMapper.selectByExample(example);
        if(null != rootDirectoriesList && !rootDirectoriesList.isEmpty()){
            for (ReleasePerson releasePerson:rootDirectoriesList){
                ReleaseSystemPersonExample releaseSystemPersonExample = new ReleaseSystemPersonExample();
                ReleaseSystemPersonExample.Criteria criteriaReleaseSystemPersonExample=  releaseSystemPersonExample.createCriteria();
                criteriaReleaseSystemPersonExample.andReleasepersonidEqualTo(releasePerson.getId());
                List<ReleaseSystemPerson> releaseSystemPersonList = releaseSystemPersonMapper.selectByExample(releaseSystemPersonExample);
                if(null != releaseSystemPersonList && !releaseSystemPersonList.isEmpty()){
                    for(ReleaseSystemPerson releaseSystemPerson:releaseSystemPersonList){
                        ReleaseSystemExample releaseSystemExample = new ReleaseSystemExample();
                        ReleaseSystemExample.Criteria criteriaReleaseSystemExample= releaseSystemExample.createCriteria();
                        criteriaReleaseSystemExample.andIsUsedEqualTo("1");
                        criteriaReleaseSystemExample.andIdEqualTo(releaseSystemPerson.getReleasesystemid());
                        List<ReleaseSystem> releaseSystemList = releaseSystemMapper.selectByExample(releaseSystemExample);
                        ReleasePersonModel releasePersonModel = new ReleasePersonModel();
                        BeanUtils.copyProperties(releasePersonModel,releasePerson);
                        if(null != releaseSystemList && !releaseSystemList.isEmpty()){
                            ReleaseSystem  releaseSystem = releaseSystemList.get(0);
                            releasePersonModel.setSystemName(releaseSystem.getSystemName());
                            releasePersonModels.add(releasePersonModel);
                        }
                    }

                }

            }
        }
        int totalCount = releasePersonMapper.countByExample(example);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("list",releasePersonModels);
        return map;
    }

    @RequestMapping("/savePersion")
    @ResponseBody
    public Map<String, String> savePersion(String sysId, String releaseName){
        Map<String,String> returnMap = new HashMap<String,String>();
        if(StringUtils.isEmpty(sysId)){
            returnMap.put("returnCode","000000");
            returnMap.put("returnMessage","请选择系统");
            return returnMap;
        }
        if(StringUtils.isEmpty(releaseName)){
            returnMap.put("returnCode","000000");
            returnMap.put("returnMessage","发布人不能为空");
            return returnMap;
        }
        ReleasePerson releasePerson = new ReleasePerson();
        releasePerson.setIsused("1");
        releasePerson.setCreatedate(new Date());
        releasePerson.setReleasename(releaseName);
        releasePersonMapper.insertSelective(releasePerson);
        ReleaseSystemPerson releaseSystemPerson = new ReleaseSystemPerson();
        releaseSystemPerson.setReleasepersonid(releasePerson.getId());
        releaseSystemPerson.setReleasesystemid(Integer.parseInt(sysId));
        releaseSystemPersonMapper.insert(releaseSystemPerson);
        returnMap.put("returnCode","111111");
        returnMap.put("returnMessage","success");
        return returnMap;
    }

}
