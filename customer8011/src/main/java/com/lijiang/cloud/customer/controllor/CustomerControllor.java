package com.lijiang.cloud.customer.controllor;


import com.lijiang.cloud.customer.conf.CustomerConfig;
import com.lijiang.cloud.customer.service.RedisService;
import com.lijiang.springcloud.entities.YlgjCompanyDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
public class CustomerControllor {
    static final String PRIVIDER_URL="localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/insertDept")
    @ResponseBody//@RequestBody接收JSON  @Param()@RequestParam 接收FORM-data
    public Map<String ,Object> insertDept(@RequestBody YlgjCompanyDept ylgjCompanyDept){
        Map<String ,Object> result=new HashMap<>(  );
        try{
            if (restTemplate.postForObject(PRIVIDER_URL+"/insert" ,ylgjCompanyDept,Map.class ).get( "state" ).equals( 1 )){
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

    @RequestMapping(value = "/insertRedis")
    @ResponseBody//@RequestBody接收JSON  @Param()@RequestParam 接收FORM-data
    public Map<String ,Object> insertRedis(String key,String value){
        Map<String ,Object> result=new HashMap<>(  );
        try{
            if (redisService.set( key,value )){
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
    @RequestMapping(value = "/getRedis")
    @ResponseBody//@RequestBody接收JSON  @Param()@RequestParam 接收FORM-data
    public Map<String ,Object> getRedis(String key){
        Map<String ,Object> result=new HashMap<>(  );
        try{
                result.put( "data", redisService.get( key ));
                result.put( "state",1 );
                result.put( "message","success" );
        }catch (Exception e){
            result.put( "state",-1 );
            result.put( "message","error" );
        }
        return result;
    }
}
