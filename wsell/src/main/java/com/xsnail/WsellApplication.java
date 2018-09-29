package com.xsnail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@MapperScan("com.xsnail.mapper")
public class WsellApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsellApplication.class, args);
	}
}
