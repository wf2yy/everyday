package com.smile.tkpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.smile.tkpro.mapper")
public class TkProApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkProApplication.class, args);
	}
}
