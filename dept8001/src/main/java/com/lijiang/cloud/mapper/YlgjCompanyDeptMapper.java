package com.lijiang.cloud.mapper;

import com.lijiang.springcloud.entities.YlgjCompanyDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YlgjCompanyDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YlgjCompanyDept record);

    int insertSelective(YlgjCompanyDept record);

    YlgjCompanyDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YlgjCompanyDept record);

    int updateByPrimaryKey(YlgjCompanyDept record);
}