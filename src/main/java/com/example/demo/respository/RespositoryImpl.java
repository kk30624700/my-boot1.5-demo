package com.example.demo.respository;

import org.springframework.stereotype.Repository;

@Repository
public class RespositoryImpl implements IRespository {

	@Override
	public String getData() {
		return "Hello World";
	}

}
