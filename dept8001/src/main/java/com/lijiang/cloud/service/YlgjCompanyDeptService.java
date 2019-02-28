package com.lijiang.cloud.service;

import com.lijiang.springcloud.entities.YlgjCompanyDept;
import com.lijiang.cloud.mapper.YlgjCompanyDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class YlgjCompanyDeptService {
    @Autowired
    private YlgjCompanyDeptMapper ylgjCompanyDeptMapper;

    public boolean insertDept(YlgjCompanyDept ylgjCompanyDept){
        return (ylgjCompanyDeptMapper.insertSelective( ylgjCompanyDept )>0)?true:false;
    }
    public YlgjCompanyDept getById(Integer id){
        return ylgjCompanyDeptMapper.selectByPrimaryKey( id );
    }
}
