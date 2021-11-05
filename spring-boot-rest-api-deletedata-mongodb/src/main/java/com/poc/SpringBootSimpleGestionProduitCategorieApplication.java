package com.poc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class SpringBootSimpleGestionProduitCategorieApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleGestionProduitCategorieApplication.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {

	}
	
}
