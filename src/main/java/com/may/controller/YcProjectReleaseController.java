package com.may.controller;

import com.github.pagehelper.PageHelper;
import com.may.controller.model.ReleaseModel;
import com.may.mybatis.dao.ReleaseListMapper;
import com.may.mybatis.dao.ReleasePersonMapper;
import com.may.mybatis.model.ReleaseListExample;
import com.may.mybatis.model.ReleaseListWithBLOBs;
import com.may.mybatis.model.ReleasePerson;
import com.may.mybatis.model.ReleasePersonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by mayxys on 2016/6/29.
 */
@Controller
public class YcProjectReleaseController {
    private static final int defaultPageSize = 10;
    @Autowired
    private ReleaseListMapper releaseListMapper;
    @Autowired
    private ReleasePersonMapper releasePersonMapper;
    @RequestMapping(value = {"/release","/"},method = RequestMethod.GET)
    public String toReleaseList(){
        System.out.print("sdsdssdsddddddd");
        return "releaseList.html";
    }
    @RequestMapping(value = "/saveReleaseList",method = RequestMethod.POST)
    public String  saveReleaseList(ReleaseModel releaseModel){
        String returnMessage="";
        String  returnCode = "";
        String  createperson = releaseModel.getCreateperson();
        if(!StringUtils.isEmpty(createperson)){
            returnMessage="???????";
        }
        if (!StringUtils.isEmpty(releaseModel.getPathlist())){
            returnMessage="??q??????";
        }
        if (!StringUtils.isEmpty(releaseModel.getReleaseMark())){
            returnMessage="????????";
        }

        ReleaseListWithBLOBs releaseListWithBLOBs = new ReleaseListWithBLOBs();
        releaseListWithBLOBs.setSystemname(releaseModel.getSystemname());
        releaseListWithBLOBs.setCreateperson(releaseModel.getCreateperson());
        releaseListWithBLOBs.setCreatedate(new Date());
        releaseListWithBLOBs.setPathlist(releaseModel.getPathlist());
        releaseListWithBLOBs.setReleaseMark(releaseModel.getReleaseMark());
        releaseListWithBLOBs.setIsused("1");
        releaseListMapper.insert(releaseListWithBLOBs);
        return "";
    }
    @RequestMapping(value = "/releasePersonList")
    @ResponseBody
    public List<ReleasePerson> getReleasePerson(String systemName){
        ReleasePersonExample releasePersonExample = new ReleasePersonExample();
        ReleasePersonExample.Criteria criteria = releasePersonExample.createCriteria();
        criteria.andSystemcodeEqualTo(systemName);
        releasePersonExample.setOrderByClause("createDate desc");
        List<ReleasePerson>  releasePersonList = releasePersonMapper.selectByExampleWithBLOBs(releasePersonExample);
        return releasePersonList;
    }

    @RequestMapping(value = "/List")
    public String topeleasePathList(){
       return "releaseListShow.html";
    }


    @RequestMapping(value = "/pathList")
    @ResponseBody
    public List<ReleaseListWithBLOBs> peleasePathList(){
        PageHelper.startPage(1,defaultPageSize);
        ReleaseListExample releaseListExample = new ReleaseListExample();
        List<ReleaseListWithBLOBs> releaseListWithBLOBs = releaseListMapper.selectByExampleWithBLOBs(releaseListExample);
        return releaseListWithBLOBs;
    }

    @RequestMapping(value = "/releasePersonListPage")
    @ResponseBody
    public Map<String, Object> releasePersonListPage(String pageNum, String pageSize){
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
        List<ReleaseListWithBLOBs>  releaseListWithBLOBs= releaseListMapper.selectByExampleWithBLOBs(releaseListExample);
        if(null != releaseListWithBLOBs && !releaseListWithBLOBs.isEmpty()){
            for(ReleaseListWithBLOBs release:releaseListWithBLOBs){

            }
        }
        int totalCount = releaseListMapper.countByExample(null);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",Math.ceil(totalCount*1.0/Double.parseDouble(pageSize)));
        map.put("releaseListWithBLOBs",releaseListWithBLOBs);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFile")
    public String removeFile(String fileId){
        ReleaseListWithBLOBs record = new ReleaseListWithBLOBs();
        record.setIsused("0");
        ReleaseListExample example = new ReleaseListExample();
        ReleaseListExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(fileId));
        releaseListMapper.updateByExampleSelective(record,example);
        return "1";
    }




}
