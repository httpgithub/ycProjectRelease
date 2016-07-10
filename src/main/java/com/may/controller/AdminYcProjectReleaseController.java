package com.may.controller;

import com.github.pagehelper.PageHelper;
import com.may.mybatis.dao.RootDirectoriesMapper;
import com.may.mybatis.model.RootDirectories;
import com.may.mybatis.model.RootDirectoriesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mayxys on 2016/7/10.
 */
@Controller
public class AdminYcProjectReleaseController {
    @Autowired
    private RootDirectoriesMapper rootDirectoriesMapper;
    private static final int defaultPageSize = 10;
    @RequestMapping(value = "/rootDirectories")
    public String toRootDirectoriesShowPage(){
        return "rootDirectoriesShow.html";
    }
    @RequestMapping(value = "/rootDirectoriesListPage")
    @ResponseBody
    public Map<String, Object> rootDirectoriesListPage(String pageNum, String pageSize){
        int num = 1;
        if(!StringUtils.isEmpty(pageNum)){
            num=Integer.parseInt(pageNum);
        }
        if(!StringUtils.isEmpty(pageSize)){
            pageSize=String.valueOf(defaultPageSize);
        }
        PageHelper.startPage(num,Integer.parseInt(pageSize));
        RootDirectoriesExample example = new RootDirectoriesExample();
        RootDirectoriesExample.Criteria criteria = example.createCriteria();
        criteria.andIsusedEqualTo("1");
        example.setOrderByClause("create_date desc");
        List<RootDirectories> RootDirectoriesList = rootDirectoriesMapper.selectByExample(example);
        int totalCount = rootDirectoriesMapper.countByExample(null);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("rootDirectoriesList",RootDirectoriesList);
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
}
