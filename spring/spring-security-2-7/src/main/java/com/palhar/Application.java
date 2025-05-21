package com.palhar;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
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


	// @Autowired
    // private PasswordEncoder passwordEncoder;
    // @Autowired
    // private UserDetailsService userDetailsService; // To simulate loading a user

	// /** implements CommandLineRunner -- && -- @Override public void run(String... args) throws Exception {} */
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {
	// 		System.out.println("\n--- Password Verification START ---");
	// 		// String rawPassword = "Hello123"; // Use your actual raw password here, or "jbgu87jh"
	// 		String userRawPassword = "Hello123"; // The password for user "user"
	// 		String adminRawPassword = "Hello123"; // The password for user "admin"
	// 		// Let's print out what your passwordEncoder.encode() does
	// 		String encodedUserPasswordInConfig = passwordEncoder.encode(userRawPassword);
	// 		String encodedAdminPasswordInConfig = passwordEncoder.encode(adminRawPassword);
	// 		System.out.println("Encoded password for 'user' (from config): " + encodedUserPasswordInConfig);
	// 		System.out.println("Encoded password for 'admin' (from config): " + encodedAdminPasswordInConfig);
	// 		// Test if the encoder can match the raw password against the encoded one
	// 		boolean userMatches = passwordEncoder.matches(userRawPassword, encodedUserPasswordInConfig);
	// 		System.out.println("Does raw 'user' password '" + userRawPassword + "' match its encoded version? " + userMatches);
	// 		boolean adminMatches = passwordEncoder.matches(adminRawPassword, encodedAdminPasswordInConfig);
	// 		System.out.println("Does raw 'admin' password '" + adminRawPassword + "' match its encoded version? " + adminMatches);
	// 		// This should always be true if BCryptPasswordEncoder is correctly configured and the raw string is the same.
	// 		if (!userMatches || !adminMatches) {
	// 			System.err.println("CRITICAL ERROR: PasswordEncoder is not correctly matching passwords!");
	// 		}
	// 		// Test with a user loaded from UserDetailsService
	// 		try {
	// 			// This is just a sanity check to see if the userDetailsService can load the user It doesn't perform password validation here directly.
	// 			userDetailsService.loadUserByUsername("user");
	// 			System.out.println("User 'user' successfully loaded by UserDetailsService.");
	// 		} catch (Exception e) {
	// 			System.err.println("Error loading user 'user' from UserDetailsService: " + e.getMessage());
	// 		}
	// 		System.out.println("--- Password Verification END ---\n");
	// 	};
    // }



}
