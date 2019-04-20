package com.kevin.sericefeign.controller;

import com.kevin.sericefeign.service.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈simple function description〉<br>
 * 〈〉
 *
 * @author kevin
 * @create 2019/4/3
 * @since 1.0.0
 */
@RestController
public class HiController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    ScheduleServiceHi scheduleServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayHiFromClientOne( name );
    }

}
