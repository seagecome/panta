package com.wanwu.panta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.wanwu.panta.dal.mapper")
public class PantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantaApplication.class, args);
	}

}

