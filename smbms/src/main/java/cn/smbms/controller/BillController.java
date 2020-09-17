package cn.smbms.controller;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.bill.BillServiceImpl;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.service.provider.ProviderServiceImpl;
import cn.smbms.tools.Constants;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private ProviderService providerService;
    @Autowired
    private BillService billService;

    /*查询订单列表*/
    @RequestMapping("/billList.html")
    public String getBillList(
            @RequestParam(value = "queryProductName", defaultValue = "") String queryProductName,
            @RequestParam(value = "queryProviderId", defaultValue = "0") Integer queryProviderId,
            @RequestParam(value = "queryIsPayment", defaultValue = "0") Integer queryIsPayment,
            Model model
    ) {
        List<Provider> providerList = new ArrayList<Provider>();
        providerList = providerService.getProviderList("", "");
        model.addAttribute("providerList", providerList);
        List<Bill> billList = new ArrayList<Bill>();
        Bill bill = new Bill();
        bill.setIsPayment(queryIsPayment);
        bill.setProviderId(queryProviderId);
        bill.setProductName(queryProductName);
        billList = billService.getBillList(bill);
        model.addAttribute("billList", billList);
        model.addAttribute("queryProductName", queryProductName);
        model.addAttribute("queryProviderId", queryProviderId);
        model.addAttribute("queryIsPayment", queryIsPayment);
        return "billlist";
    }

    @RequestMapping("/toadd.html")
    public String toadd() {
        return "billadd";
    }


    @RequestMapping("/add.html")
    public String add(Bill bill, HttpSession session) {
        bill.setCreatedBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());
        bill.setCreationDate(new Date());
        boolean flag = false;
        flag = billService.add(bill);
        System.out.println("add flag -- > " + flag);
        if (flag) {
            return "redirect:/bill/billList.html";
        } else {
            return "billadd";
        }

    }


    @RequestMapping("/tomodify.html")
    public String getBillById(@RequestParam("billid") String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            Bill bill = null;
            bill = billService.getBillById(id);
            model.addAttribute("bill", bill);
            return "billmodify";
        } else {
            throw new RuntimeException("数据不能为空，没有获取到billid");
        }
    }

    @RequestMapping("/modifysave.html")
    public String modifySave(Bill bill, HttpServletRequest request) {
        bill.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        bill.setModifyDate(new Date());
        System.out.println(bill);
        boolean flag = false;
        flag = billService.modify(bill);
        if (flag) {
            return "redirect:/bill/billList.html";
        } else {
            return "billmodify";
        }
    }


    @RequestMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            Bill bill = null;
            bill = billService.getBillById(id);
            model.addAttribute("bill", bill);
            return "billview";
        } else {
            throw new RuntimeException("数据不能为空，没有获取到billid");
        }
    }

    @RequestMapping("/bcexists.html")
    @ResponseBody
    public String ucExist(@RequestParam("billCode") String billCode) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (StringUtils.isNullOrEmpty(billCode)) {
            resultMap.put("billCode", "exist");
        } else {
            Bill bill = billService.selectBillCodeExist(billCode);
            if (null != bill) {
                resultMap.put("billCode", "exist");
            } else {
                resultMap.put("billCode", "notexist");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getproviderlist",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getProviderList() {
        List<Provider> providerList = new ArrayList<Provider>();
        providerList = providerService.getProviderList("", "");
        //把providerList转换成json对象输出
        return JSONArray.toJSONString(providerList);
    }



    @RequestMapping("/delbill")
    @ResponseBody
    public String delBill(@RequestParam("billid") String id){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(id)){
            boolean flag = billService.deleteBillById(id);
            if(flag){//删除成功
                resultMap.put("delResult", "true");
            }else{//删除失败
                resultMap.put("delResult", "false");
            }
        }else{
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        return JSONArray.toJSONString(resultMap);
    }

}
