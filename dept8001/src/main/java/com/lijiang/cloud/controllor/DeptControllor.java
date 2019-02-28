package com.lijiang.cloud.controllor;

import com.lijiang.cloud.service.YlgjCompanyDeptService;
import com.lijiang.springcloud.entities.YlgjCompanyDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/dept")
public class DeptControllor {

    @Autowired
    private YlgjCompanyDeptService ylgjCompanyDeptService;

    @RequestMapping(value = "/insert")
    @ResponseBody//@RequestBody接收JSON  @Param()@RequestParam 接收FORM-data
    public Map<String ,Object> insertDept(@RequestBody YlgjCompanyDept ylgjCompanyDept){
        Map<String ,Object> result=new HashMap<>(  );
        try{
            if (ylgjCompanyDeptService.insertDept( ylgjCompanyDept )){
                result.put( "state",1 );
                result.put( "message","success" );
            }
            else {
                result.put( "state",0 );
                result.put( "message","fail" );
            }
        }catch (Exception e){
            result.put( "state",-1 );
            result.put( "message","error" );
        }
        return result;
    }
    @RequestMapping(value = "/get")
    @ResponseBody
    public Map<String ,Object> getDept(@Param( value ="deptId" ) Integer deptId){
        Map<String ,Object> result=new HashMap<>(  );
        try{
            YlgjCompanyDept ylgjCompanyDept=ylgjCompanyDeptService.getById(deptId);
            if (null!=ylgjCompanyDept){
                result.put( "state",1 );
                result.put( "state",ylgjCompanyDept);
                result.put( "message","success" );
            }
            else {
                result.put( "state",0 );
                result.put( "message","fail" );
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put( "state",-1 );
            result.put( "message","error" );
        }
        return result;
    }
}
