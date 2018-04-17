package com.example.demo.boot.basic.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.example.demo.springbasic.scheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}
