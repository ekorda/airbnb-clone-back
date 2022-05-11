package com.example.airbnbcloneback;

import com.example.airbnbcloneback.domain.AppRole;
import com.example.airbnbcloneback.domain.AppUser;
import com.example.airbnbcloneback.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AirbnbCloneBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbCloneBackApplication.class, args);
	}


	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new AppRole(null, "ROLE_ADMIN"));
			userService.saveRole(new AppRole(null, "ROLE_LANDLORD"));
			userService.saveRole(new AppRole(null, "ROLE_TENANT"));


			userService.saveUser(new AppUser(null, "Abe", "abe", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Kebe", "kebe", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Key", "key", "1234", new ArrayList<>()));

			userService.addRoleToUser("abe", "ROLE_ADMIN");
			userService.addRoleToUser("kebe", "ROLE_LANDLORD");
			userService.addRoleToUser("key", "ROLE_TENANT");
			userService.addRoleToUser("key", "ROLE_LANDLORD");

		};
	}

}
