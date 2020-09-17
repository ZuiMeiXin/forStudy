package com.hisoft.service;

import com.hisoft.dao.procider.ProviderDao;
import com.hisoft.pojo.Provider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Resource(name = "providerDao")
    private ProviderDao providerDao;

    @Override
    public int addProvider(Provider provider) {
        providerDao.addProvider(provider);
        return 1;
    }
}
