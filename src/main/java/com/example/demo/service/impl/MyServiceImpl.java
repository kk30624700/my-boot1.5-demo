package com.example.demo.service.impl;

import com.example.demo.service.MyService;

public class MyServiceImpl implements MyService {
	public String getMsg()  {
		return "Hello world!";
	}
	public String getMsg(String msg) {
		return "Hello, " + msg + "!";
	}
}
