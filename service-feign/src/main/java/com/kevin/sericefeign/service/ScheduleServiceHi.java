package com.kevin.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *通过@ FeignClient（“服务名”），来指定调用哪个服务
 *
 * feign中使用hystrix只需要在FeignClient的 ScheduleServiceHi 接口的注解中加上fallback的指定类就行
 * 指定类需要实现 ScheduleServiceHi 接口，并注入到Ioc容器中
 * @author kevin
 * @create 2019/4/3
 * @since 1.0.0
 */
@FeignClient(value = "eureka-client",fallback = ScheduleServiceHiHystrix.class)
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
