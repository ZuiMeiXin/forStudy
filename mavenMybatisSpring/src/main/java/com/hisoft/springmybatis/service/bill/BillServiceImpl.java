package com.hisoft.springmybatis.service.bill;

import com.hisoft.springmybatis.dao.bill.BillMapper;
import com.hisoft.springmybatis.pojo.Bill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("billService")
public class BillServiceImpl implements BillService {
    @Resource
    private BillMapper billMapper;

    @Override
    public List<Bill> getBillLest() {
        return billMapper.getBillList();
    }

    @Override
    public List<Bill> getBillListByMap(Map map) {
        return billMapper.getBillListByMap(map);
    }
}
