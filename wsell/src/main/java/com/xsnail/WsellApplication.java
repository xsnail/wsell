package com.xsnail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WsellApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsellApplication.class, args);
	}
}
