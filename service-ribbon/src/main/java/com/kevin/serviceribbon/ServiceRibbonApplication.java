package com.kevin.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。
 */
@SpringBootApplication
@EnableEurekaClient // 如果使用的是eureka注册中心的话,推荐用此注解 TODO
// @EnableDiscoveryClient // 与上个注解功能类似
@EnableHystrix  // 开启hystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
