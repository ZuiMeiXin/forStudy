package com.bill;

import com.hisoft.springmybatis.pojo.Bill;
import com.hisoft.springmybatis.service.bill.BillService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillTest {
    @Test
    public void getBillList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BillService billService = (BillService) context.getBean("billService");
        List<Bill> billLest = billService.getBillLest();
        for (Bill bill : billLest) {
            System.out.println(bill);
        }
    }


    @Test
    public void getBill() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BillService billService = (BillService) context.getBean("billService");
        Map map = new HashMap();
        map.put("productName", "米");
//        map.put("providerId", );
        map.put("isPayment", 2);
        List<Bill> billListByMap = billService.getBillListByMap(map);
        for (Bill bill : billListByMap) {
            System.out.println(bill);

        }
    }
}
