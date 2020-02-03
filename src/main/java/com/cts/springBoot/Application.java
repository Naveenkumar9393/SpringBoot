package com.cts.springBoot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.productServices.ProductServiceImplementation;

@SpringBootApplication
public class Application implements ApplicationRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello World Runner");
	}

	@Bean
	public ProductServiceImplementation getProductDetails() {
		return new ProductServiceImplementation();
	}

	@Bean
	public WebMvcConfigurer webmvcBean() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getProductList").allowedOrigins("http://localhost:3045");
			}
		};
	}
}
