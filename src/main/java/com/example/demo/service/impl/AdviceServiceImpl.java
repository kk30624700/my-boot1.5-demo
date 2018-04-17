package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.respository.IRespository;
import com.example.demo.service.IAdviceService;

@Service
public class AdviceServiceImpl implements IAdviceService {
	@Autowired
	IRespository iRepository;
	@Override
	public void service() {
		System.out.println(iRepository.getData());
	}
	
	//将被MyAdvice的permissionCheck方法匹配
	@Override
    public void beforeAdvice() {
        System.out.println("方法: beforeAdviceTest");
    }
    
    //将被MyAdvice的log方法匹配
	@Override
    public String afterReturningAdvice() {
        System.out.println("方法：afterReturning");
        return "afterReturning方法";
    }
    
    //将被MyAdvice的handleException方法匹配
	@Override
    public void afterThrowingAdvice() {
        System.out.println("方法： afterThrowing");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("算术异常已被处理");
        }
        String s = null;
        System.out.println(s.substring(0,3));
    }
    
    //将被MyAdvice的releaseResource方法匹配
	@Override
    public void afterAdvice() {
        System.out.println("方法： afterAdvice");
    }
    
    //将被MyAdvice的process方法匹配
	@Override
    public String aroundAdvice(String param1, Integer param2, Object param3) {
        System.out.println("方法： aroundAdvice");
        return param1;
    }
    
    //将被MyAdvice的access方法匹配
	@Override
    public String accessAdvice(Date d, String n) {
        System.out.println("方法：accessAdvice");
        return "aa";
    }
    
    //将被OtherAdvice的各种方法匹配
	@Override
    public String manyAdvices(String param1, String param2) {
        System.out.println("方法：manyAdvices");
        return param1 + " 、 " + param2;
    }
}
