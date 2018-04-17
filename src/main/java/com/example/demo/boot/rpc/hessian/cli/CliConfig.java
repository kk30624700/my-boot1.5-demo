package com.example.demo.boot.rpc.hessian.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.example.demo.service.MyService;

@Configuration
@ComponentScan
public class CliConfig {
	@Bean
	public HessianProxyFactoryBean myService() {
		HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
		
		proxy.setServiceUrl("http://localhost:8080/hessian/myService.service");
		proxy.setServiceInterface(MyService.class);
		
		
		return proxy;
	}
}
