package cn.smbms.service.bill;

import java.util.List;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean add(Bill bill) {
        boolean flag = false;
        if (billMapper.add(bill) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        List<Bill> billList = null;
        billList = billMapper.getBillList(bill);
        return billList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteBillById(String delId) {
        boolean flag = false;
        if (billMapper.deleteBillById(delId) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        bill = billMapper.getBillById(id);
        return bill;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean modify(Bill bill) {
        boolean flag = false;
        if (billMapper.modify(bill) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Bill selectBillCodeExist(String billCode) {
        Bill bill = null;
        bill = billMapper.getBillByBillCode(billCode);
        return bill;
    }

}
