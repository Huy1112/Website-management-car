package com.example.otocu.demo;

import com.example.otocu.demo.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class OtocuApplication implements WebMvcConfigurer {


	public static void main(String[] args) {
		SpringApplication.run(OtocuApplication.class, args);
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login");
	}
}
