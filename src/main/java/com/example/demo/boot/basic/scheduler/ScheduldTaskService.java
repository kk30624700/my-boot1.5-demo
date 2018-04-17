package com.example.demo.boot.basic.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduldTaskService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 2000)
	public void reportCurrentTime() {
		System.out.println("每隔2秒执行一次 " + dateFormat.format(new Date()));
	}
	@Scheduled(cron = "* * * * * *")
	public void fixTimeExecution() {
		System.out.println("在指定的时间 " + dateFormat.format(new Date()) + " 执行");
	}
}
