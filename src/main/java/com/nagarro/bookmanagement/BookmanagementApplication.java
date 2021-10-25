package com.nagarro.bookmanagement;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nagarro.bookmanagement.dao.LoginDao;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.nagarro.bookmanagement.controller"})
public class BookmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagementApplication.class, args);
	}

	@Bean
	public LoginDao getLoginDao() {
	return new LoginDao();
	}
}
