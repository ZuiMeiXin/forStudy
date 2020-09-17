package com.hisoft.dao.provider;

import com.hisoft.pojo.Provider;
import org.springframework.stereotype.Repository;

@Repository("providerDao")
public class ProviderDaoImpl implements ProviderDao {
    @Override
    public int addProvider(Provider provider) {
        System.out.println("执行了添加供应商方法");
        return 1;
    }
}
