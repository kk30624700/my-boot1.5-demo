package com.example.demo.boot.rpc.rmi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.service.MyService;

public class TestCli {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("default");
		context.register(RmiCliConfig.class);
		context.refresh();

		System.out.println(context.getBean(MyService.class).getMsg("M24"));

		context.close();
	}
}
