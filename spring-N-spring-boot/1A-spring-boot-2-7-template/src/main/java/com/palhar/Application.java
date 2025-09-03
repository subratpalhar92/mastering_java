package com.palhar;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

	/**
	 * For Devtools
	 */
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    // @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {
	// 		System.out.println("Start : Let's inspect the beans provided by Spring Boot MY \"Application.java\":");
	// 		String[] beanNames = ctx.getBeanDefinitionNames();
	// 		Arrays.sort(beanNames);
	// 		for (String beanName : beanNames) {
	// 			System.out.println(beanName);
	// 		}
	// 		System.out.println("End: Let's inspect the beans provided by Spring Boot MY \"Application.java\":");
	// 	};
	// }

	@GetMapping("/ready")
	public String ready() {
		return "Application Is Ready To Serve.";
	}

}
