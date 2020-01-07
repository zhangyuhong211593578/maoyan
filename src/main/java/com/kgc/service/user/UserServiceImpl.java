package com.kgc.service.user;


import com.kgc.dao.UserDao;
import com.kgc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        // TODO Auto-generated method stub
        List<User> user = null;
        try {
            user = userDao.getUserList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    public List<User> getList() {
        // TODO Auto-generated method stub
        List<User> user = null;
        try {
            user = userDao.getList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            user = null;
        }
        return user;
    }

}
