# 项目介绍  
本项目是一个spring cloud各组件使用的演示项目,其中包括了5个子模块具体如下:    
## 1,eureka-server:
基于eureka的服务注册中心,进行服务发现/治理,所有服务组件均需向注册中心进行服务注册,  
必须最先进行启动;  
## 2,eureka-client:
服务提供者,需向注册中心进行服务注册;
## 3,service-feign:
基于feign组件的用于进行负载均衡的服务;
## 4,service-ribbon:
基于ribbon的用于进行负载均衡的服务,3服务在此基础上实现,可只启动两者中的一个
## 5,service-zuul: 
基于zuul的一个用于进行网关路由的服务;  
## 6,config-server: 
配置中心服务,可对配置进行动态管理,基于bus服务上可以实现动态刷新配置(通过amqp实现);
  要在config-client 启动之前启动;     
## 7,config-client: 
一个演示动态配置的服务实例;  
  配置规则是applicationName-profile.yml/properties：如config-client-dev.properties 
  以下为1.3.1版本支持的配置格式：
  /{application}/{profile}[/{label}]
  /{application}-{profile}.yml
  /{label}/{application}-{profile}.yml
  /{application}-{profile}.properties
  /{label}/{application}-{profile}.properties
## 8,admin-server:
基于spring  admin进行应用可视化管理
