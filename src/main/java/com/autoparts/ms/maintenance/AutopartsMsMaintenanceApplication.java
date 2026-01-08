package com.autoparts.ms.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.autoparts.core.entity.annotation.EnableNativeQueryRepositories;

@SpringBootApplication
@ComponentScan({"com.autoparts"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.autoparts"})
@EnableNativeQueryRepositories(basePackages = "com.autoparts.ms.maintenance.repository")
public class AutopartsMsMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutopartsMsMaintenanceApplication.class, args);
	}

}
