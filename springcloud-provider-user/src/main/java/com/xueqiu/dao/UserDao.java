package com.xueqiu.dao;

import com.xueqiu.pojo.UserList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:37
 */
@Mapper
@Repository
public interface UserDao {
    /**
     *查找全部用户
     * @return
     */
    List<UserList> queryAllUser();

    /**
     *插入一个用户
     * @param userList
     * @return
     */
    int insertUser(UserList userList);

    /**
     *删除一个用户
     * @param userId
     * @return
     */
    int deleteUser(String  userId);

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    UserList queryUser(String userId);

    /**
     * 修改一个用户
     * @param userList
     * @return
     */
    int updateUser(UserList userList);

    /**
     * 查找用户名
     * @param userId
     * @return
     */
    String selectUsername(String userId);
}
