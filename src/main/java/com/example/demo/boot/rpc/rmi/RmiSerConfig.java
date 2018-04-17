package com.example.demo.boot.rpc.rmi;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.example.demo.service.MyService;
import com.example.demo.service.impl.MyServiceImpl;

@Configuration
@ComponentScan
public class RmiSerConfig {
	@Bean
	public RmiServiceExporter rmiExporter(MyService myService) {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setService(myService);
		rmiServiceExporter.setServiceName("MyService");
		rmiServiceExporter.setServiceInterface(MyService.class);
//		rmiServiceExporter.setRegistryHost("127.0.0.1");
//		rmiServiceExporter.setRegistryPort(1199);
		return rmiServiceExporter;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MyService myService() {
		return new MyServiceImpl();
	}
	
}
