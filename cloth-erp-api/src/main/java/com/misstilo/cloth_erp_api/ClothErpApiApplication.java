package com.misstilo.cloth_erp_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.misstilo.cloth_erp_api.mapper")
public class ClothErpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothErpApiApplication.class, args);
	}

}
