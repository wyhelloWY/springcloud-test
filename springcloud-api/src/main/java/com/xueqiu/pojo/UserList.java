package com.xueqiu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户表
 * @author Yu W
 * @date 2020/12/1 10:21
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserList {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id/学号
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户性别
     */
    private Integer userSex;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户注册时间
     */
    private Date userRegist;

    /**
     * 用户登录时间
     */
    private Date userLogin;

    /**
     * 标明在哪个数据库
     * 一个服务对应一个数据库  同一个信息可能存储在不同数据库
     */
    private String db_source;

    public UserList(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
}
