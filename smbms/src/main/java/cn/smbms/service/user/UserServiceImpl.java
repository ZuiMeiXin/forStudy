package cn.smbms.service.user;


import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 *
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean add(User user) {
        boolean flag = false;
        try {
            int updateRows = userMapper.add(user);
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("rollback==================");
        }
        return flag;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User login(String userCode, String userPassword) {
        User user = null;
        user = userMapper.getLoginUser(userCode);
        return user;
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = null;
        System.out.println(currentPageNo);
        userList = userMapper.getUserList(queryUserName, queryUserRole, (currentPageNo - 1) * pageSize, pageSize);
        return userList;
    }

    @Override
    public User selectUserCodeExist(String userCode) {
        User user = null;
        try {
            user = userMapper.getLoginUser(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteUserById(Integer delId) {
        boolean flag = false;
        if (userMapper.deleteUserById(delId) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        try {
            user = userMapper.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean modify(User user) {
        boolean flag = false;
        if (userMapper.modify(user) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updatePwd(int id, String pwd) {
        boolean flag = false;
        if (userMapper.updatePwd(id, pwd) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        int count = 0;
        count = userMapper.getUserCount(queryUserName, queryUserRole);
        return count;
    }

}
