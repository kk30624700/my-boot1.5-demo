package com.example.demo.boot.basic.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.demo.springbasic.respository", "com.example.demo.springbasic.service"})
@Import({AopConfig.class, TaskExecutorConfig.class, TaskSchedulerConfig.class})
public class AppConfig {
	
}
