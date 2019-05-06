package com.kevin.configclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApplication {

    /**
     * 使用post请求方式发送以下请求,config-client会重新读取配置文件
     * 当再次请求接口:http://localhost:8882/hi 时配置已经更新
     *
     * http://localhost:8881/actuator/bus-refresh
     *
     * /actuator/bus-refresh接口可以指定服务，即使用"destination"参数，
     * 比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

//    @Value("${devCommonConfig1}")
//    String devCommonConfig1;

    @Value(("${familyName}"))
    String familyName;
    // 验证从属性文件中获取值,如果与配置中心的 key相同则会从配置中心获取;
    @Value("${propertiesConfig}")
    String propertiesConfig;

    @RequestMapping(value = "/hi")
    public String hi() {
        StringBuilder builder = new StringBuilder();

        builder.append("the foo is: ").append(foo);
        builder.append(",and the familyName is: ").append(familyName);
        builder.append(",and the propertiesConfig is: ").append(propertiesConfig);
//        builder.append(",and devCommonConfig1 is: ").append(devCommonConfig1);
        return builder.toString();
    }
}

