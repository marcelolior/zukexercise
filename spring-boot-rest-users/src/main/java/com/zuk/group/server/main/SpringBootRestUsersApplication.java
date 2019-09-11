package com.zuk.group.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zuk.group"})
public class SpringBootRestUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestUsersApplication.class, args);
			}

}
