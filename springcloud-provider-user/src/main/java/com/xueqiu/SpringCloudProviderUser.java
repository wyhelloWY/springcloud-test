package com.xueqiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/4/17 16:41
 */
@SpringBootApplication
@EnableEurekaClient  //启动之后自动注册到服务端
public class SpringCloudProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderUser.class,args);
    }
}
