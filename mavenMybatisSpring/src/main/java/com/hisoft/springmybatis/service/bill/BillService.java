package com.hisoft.springmybatis.service.bill;

import com.hisoft.springmybatis.pojo.Bill;

import java.util.List;
import java.util.Map;

public interface BillService {
    List<Bill> getBillLest();
    List<Bill> getBillListByMap(Map map);
}
