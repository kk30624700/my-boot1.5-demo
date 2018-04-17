package com.example.demo.boot.rpc.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.example.demo.service.MyService;

@Configuration
@ComponentScan
public class RmiCliConfig {
	@Bean
	public RmiProxyFactoryBean myService() {
		RmiProxyFactoryBean rmi = new RmiProxyFactoryBean();
		rmi.setServiceUrl("rmi://localhost/MyService");
		rmi.setServiceInterface(MyService.class);
		
//		rmi.setLookupStubOnStartup(false );
//		rmi.setRefreshStubOnConnectFailure(true );
//		rmi.afterPropertiesSet();
		
		return rmi;
	}
}
