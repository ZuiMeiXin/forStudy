package com.hisoft.springmybatis.dao.bill;

import com.hisoft.springmybatis.pojo.Bill;

import java.util.List;
import java.util.Map;

public interface BillMapper {
    /*获取订单集合*/
    List<Bill> getBillList();

    /*订单编码、商品名称、供应商名称、账单金额、是否付款、创建时间*/
    List<Bill> getBillListByMap(Map map);

}
