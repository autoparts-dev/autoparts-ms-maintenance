package com.autoparts.ms.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.autoparts"})
@EnableEurekaClient
@EnableCaching
public class AutopartsMsMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutopartsMsMaintenanceApplication.class, args);
	}

}
