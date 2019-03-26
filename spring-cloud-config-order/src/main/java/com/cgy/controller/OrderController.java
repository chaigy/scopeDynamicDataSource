package com.cgy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgy.dao.UserDao;

@RestController
@RefreshScope
public class OrderController {

	@Autowired
	private UserDao dao;
	
	@Value("${name}")
	private String name;
	
	
	@GetMapping("/get")
	public Map<String, Object> aa() {
		return dao.getUser(1);
	}
	
	@GetMapping("/get1")
	public String aa1() {
		return name;
	}
}
