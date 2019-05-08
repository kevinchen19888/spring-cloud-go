package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${eureka-client-key}")
    String eurekaClientKey;// 从配置中心获取值

//    @Value("${devCommonConfig1}")
//    String devCommonConfig1;

    @Value("${server.port}")
    String port;

    @Value("${kevin-name}")
    String kevinName;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "kevin") String name) {
        return "hi " + kevinName + " ,i am from port:" + port
                +" and the eurekaClientVal is: "+eurekaClientKey
//                +",devCommonConfig1 is: "+devCommonConfig1
                ;
    }


    @Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }
    }
}
