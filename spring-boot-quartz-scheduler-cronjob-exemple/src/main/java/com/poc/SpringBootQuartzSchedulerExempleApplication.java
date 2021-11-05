package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.poc.config.SchedulerConfig;

@EnableJpaAuditing
@Import({ SchedulerConfig.class })
@SpringBootApplication
@EnableFeignClients
public class SpringBootQuartzSchedulerExempleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuartzSchedulerExempleApplication.class, args);
	}

}
