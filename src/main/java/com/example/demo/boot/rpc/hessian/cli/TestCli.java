package com.example.demo.boot.rpc.hessian.cli;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.service.MyService;

public class TestCli {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CliConfig.class);
		context.getBean(MyService.class).getMsg("M24");
		context.close();
	}
}
