package com.college.fee_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class FeeStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeStudentApplication.class, args);
	}
	@Bean  
	//creating a sampler called always sampler  
	public Sampler defaultSampler()  
	{  
	return Sampler.ALWAYS_SAMPLE;  
	} 

}
