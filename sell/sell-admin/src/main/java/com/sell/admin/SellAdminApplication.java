package com.sell.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.sell")
@MapperScan("com.sell.mapper")
@EnableScheduling
public class SellAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellAdminApplication.class, args);
	}

}
