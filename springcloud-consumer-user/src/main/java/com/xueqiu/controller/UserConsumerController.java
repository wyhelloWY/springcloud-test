package com.xueqiu.controller;

import com.xueqiu.pojo.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/4/17 17:05
 */

@RestController
@RequestMapping(value = "/consumer")
public class UserConsumerController {
    /**
     * 消费者不应该有service层
     * RestTemplate 供我们直接调用就可以了  注册到spring中
     * (url,Class<T> responseType</>)
     */

    /**
     * 提供多种便捷访问远程http服务的方法  简单的restful服务模板
     */
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8081";

    @RequestMapping("/getUser/{id}")
    public UserList getUser(@PathVariable("id") String id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/getUser/"+id,UserList.class);
    }


    @RequestMapping("/list")
    public List<UserList> getUser(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/list", List.class);
    }

}
