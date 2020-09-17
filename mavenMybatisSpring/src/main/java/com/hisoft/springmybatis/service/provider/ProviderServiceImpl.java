package com.hisoft.springmybatis.service.provider;

import com.hisoft.springmybatis.dao.provider.ProviderMapper;
import com.hisoft.springmybatis.pojo.Provider;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("providerService")
@Transactional
public class ProviderServiceImpl  implements ProviderService {
    @Resource
    private ProviderMapper providerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public List<Provider> getProviderList(String proName) {
        return providerMapper.getProviderList( proName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public Integer updateProvider(String proPhone, Integer id) {
//        System.out.println(1/0);
        return providerMapper.updateProvider(proPhone,id);
    }
}
