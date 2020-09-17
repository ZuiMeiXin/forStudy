package com.hisoft.springmybatis.dao.provider;

import com.hisoft.springmybatis.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface ProviderMapper {
    /*查询所有的供应商*/
    List<Provider> getProviderList(@Param("proName") String proName);

    /*修改供应商*/
    Integer updateProvider(@Param("proPhone") String proPhone,@Param("id") Integer id);

}
