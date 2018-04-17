package com.example.demo.service;

import java.util.Date;

public interface IAdviceService {
	
	public void service();
	
    public void beforeAdvice();
    
    public String afterReturningAdvice();
    
    public void afterThrowingAdvice();
    
    public void afterAdvice();
    
    public String aroundAdvice(String param1, Integer param2, Object param3);
    
    public String manyAdvices(String param1, String param2);
    
    public String accessAdvice(Date d, String n);
}
