package com.kevin.sericefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。
 * 它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。
 * Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 *
 * 简而言之：
 * Feign 采用的是基于接口的注解
 * Feign 整合了ribbon，具有负载均衡的能力
 * 整合了Hystrix，具有熔断的能力
 * @EnableDiscoveryClient 基于spring-cloud-commons，并且在classpath中实现,
 * @EnableEurekaClient 基于spring-cloud-netflix，只能为eureka作用。
 * 如果选用的注册中心是eureka推荐@EnableEurekaClient，如果是其他的注册中心推荐使用@EnableDiscoveryClient，
 * 如果classpath中添加了eureka，则它们的作用是一样的
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }

}
