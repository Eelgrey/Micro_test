package com.college.create_student_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix

public class CreateStudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateStudentAppApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean  
	//creating a sampler called always sampler  
	public Sampler defaultSampler()  
	{  
	return Sampler.ALWAYS_SAMPLE;  
	}  
}
