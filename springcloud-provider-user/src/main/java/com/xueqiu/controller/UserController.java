package com.xueqiu.controller;

import com.xueqiu.pojo.UserList;
import com.xueqiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/4/17 16:22
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userId
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(@RequestParam("userId")String userId,
                             @RequestParam("password")String password,
                             HttpSession httpSession){
        UserList userList = userService.queryUser(userId);
        String result = "";
        if(userList!=null){
            if(userList.getUserPass().equals(password)){
                result = "登录成功";
            }else{
                result = "登录失败";
            }
        }else{
            result = "登录失败";
        }

        return result;
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/list")
    public List<UserList> list(){
        List<UserList> userLists = userService.queryAllUser();
        return userLists;
    }

    @RequestMapping("/getUser/{id}")
    public UserList getUser(@PathVariable("id")String id){
        System.out.println(id);
        UserList userList = userService.queryUser(id);
        return userList;
    }

    @Autowired
    private DiscoveryClient client;
    //注册进来的微服务 获取一些消息
    @RequestMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discover->services:" + services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-USER");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "\t"
                    +instance.getPort()+ "\t"
                    +instance.getUri()+ "\t"
                    +instance.getServiceId()+ "\t");
        }
        return this.client;
    }
}
