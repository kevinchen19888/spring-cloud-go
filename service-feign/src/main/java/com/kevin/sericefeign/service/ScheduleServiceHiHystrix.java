package com.kevin.sericefeign.service;

import org.springframework.stereotype.Component;

/**
 * 〈simple function description〉<br>
 * @author kevin
 * @create 2019/4/3
 * @since 1.0.0
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name+",ServiceFeign error,begin Hystrix";
    }
}
