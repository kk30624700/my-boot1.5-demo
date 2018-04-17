package com.example.demo.boot.el.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.boot.el.bean.DateBean;

@Service
public class DemoService {
	@Value("OTHER　VALUE")
	private String another;
	@Autowired
	private DateBean date;
	
	public String getAnother() {
		return another;
	}
	
	public void setAnother(String another) {
		this.another = another;
	}
	
	public String getDate( ) {
		return date.getYear() + date.getMonth() + date.getDay();
	}
}
