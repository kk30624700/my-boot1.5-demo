package com.example.demo.boot.basic.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages= {"com.example.demo.springbasic.aop"})
@EnableAspectJAutoProxy
public class AopConfig {

}
