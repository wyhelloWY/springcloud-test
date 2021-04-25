package com.xueqiu.service.impl;


import com.xueqiu.dao.UserDao;
import com.xueqiu.pojo.UserList;
import com.xueqiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:25
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userMapper;
    @Override
    public List<UserList> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public int insertUser(UserList userList) {
        return userMapper.insertUser(userList);
    }

    @Override
    public int deleteUser(String userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public UserList queryUser(String userId) {
        return userMapper.queryUser(userId);
    }

    @Override
    public int updateUser(UserList userList) {
        return userMapper.updateUser(userList);
    }

    @Override
    public String selectUsername(String userId) {
        return userMapper.selectUsername(userId);
    }

}
