package com.onlyjavatech.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.onlyjavatech.springbootproject.model.User;
import com.onlyjavatech.springbootproject.model.repo.UserRepo;

@SpringBootApplication
public class SpringbootprojectApplication {

	public static void main(String[] args) {
	 SpringApplication.run(SpringbootprojectApplication.class, args);
//		ConfigurableApplicationContext run = SpringApplication.run(SpringbootprojectApplication.class, args);
//
//		UserRepo bean1 = run.getBean(UserRepo.class);
//
//		User userr = new User();
//
//		userr.setCity("Delhi");
//		userr.setName("Shyam");
//		userr.setStatus("new Status");
//
//		User saveUser = bean1.save(userr);
//
//		System.out.println("-----" + saveUser);
	}

}
