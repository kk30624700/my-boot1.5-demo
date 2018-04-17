package com.example.demo.boot.rpc.hessian.ser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.MyService;
import com.example.demo.service.impl.MyServiceImpl;

@Configuration
public class RootConfig {
	@Bean
	public MyService myServiceImpl() {
		return new MyServiceImpl();
	}
}
