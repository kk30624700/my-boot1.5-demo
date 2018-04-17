package com.example.demo.boot.basic.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void executeAsyncTask(Integer i) {
		System.out.println("executeAsyncTask: " + i);
	}
	@Async
	public void executeAsyncTaskPlus(Integer i) {
		System.out.println("executeAsyncTaskPlus: " + ++i);
	}
	@Async
	public Future<String> executeAsyncTaskWithReturn() {
		try {
			Thread.sleep(3000);
			return new AsyncResult<String>("Hello World");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
