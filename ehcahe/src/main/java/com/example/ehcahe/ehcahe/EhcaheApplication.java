package com.example.ehcahe.ehcahe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * EhcaheApplication class
 *
 * @author ZHE
 * @date 2019/4/10
 */
@SpringBootApplication
@EnableCaching	//开启缓存支持
public class EhcaheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcaheApplication.class, args);
	}

}
