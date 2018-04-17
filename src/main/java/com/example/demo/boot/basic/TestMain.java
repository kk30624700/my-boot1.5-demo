package com.example.demo.boot.basic;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.boot.basic.async.AsyncTaskService;
import com.example.demo.boot.basic.conf.AppConfig;
import com.example.demo.service.IAdviceService;


public class TestMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IAdviceService service = (IAdviceService)context.getBean(IAdviceService.class);
		
		service.service();
		
		service.accessAdvice(new Date(), "test");
		service.afterAdvice();
		service.afterReturningAdvice();
		
		service.aroundAdvice("VX", 123, service);
		service.beforeAdvice();
		service.manyAdvices("param1", "param2");
		
		AsyncTaskService async = (AsyncTaskService)context.getBean(AsyncTaskService.class);
		for (int i=0; i<10; i++) {
			async.executeAsyncTask(i);
			async.executeAsyncTaskPlus(i);
		}
		Future<String> future = async.executeAsyncTaskWithReturn();
		while(true) {
			if (future.isDone()) {
				try {
					System.out.println(future.get());
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
//		service.afterThrowingAdvice();
		
		context.close();
	}
}
