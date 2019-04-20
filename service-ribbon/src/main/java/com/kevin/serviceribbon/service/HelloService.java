package com.kevin.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 〈simple function description〉<br>
 * 〈〉
 *消费实例测试
 * @author kevin
 * @create 2019/4/3
 * @since 1.0.0
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    // 对方法创建了熔断器的功能
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,service-ribbon request error!";
    }
}
