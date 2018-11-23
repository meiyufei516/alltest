package com.test.alltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@PropertySource("classpath:defineSys.properties")
public class AlltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlltestApplication.class, args);
	}
}
