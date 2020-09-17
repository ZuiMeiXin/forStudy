package com.hisoft.springmybatis.service.provider;

import com.hisoft.springmybatis.pojo.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> getProviderList(String proName);
    Integer updateProvider(String proPhone,Integer id);
}
