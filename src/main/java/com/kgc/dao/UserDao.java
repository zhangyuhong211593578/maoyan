package com.kgc.dao;

import com.kgc.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    public List<User> getUserList() throws Exception;
    @Select("select * from smbms_user")
    List<User> getList();
}
