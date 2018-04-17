package com.example.demo.boot.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.boot.el.bean.DateBean;


public class TestMain {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("V2");
		context.register(ElConfig.class);
		context.refresh();
		
		DateBean bean = context.getBean(DateBean.class);
		System.out.println(bean.getYear());
		ElConfig config = context.getBean(ElConfig.class);
		config.outputResource();
		
		System.out.println(context.getBean(ElConfig.InnerProfile.class).getVersion());
		context.close();
	}
}
