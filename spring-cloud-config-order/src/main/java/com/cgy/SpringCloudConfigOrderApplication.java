package com.cgy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cgy.dao.UserDao;

@SpringBootApplication
public class SpringCloudConfigOrderApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigOrderApplication.class, args);
	}

	@Autowired
	private UserDao dao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(dao.getUser(1));
	}

}
