package com.palhar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity /** For own SecurityFilterChain */
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            /** Disable CSRF for simplicity in development, re-enable for production */
            // .csrf(csrf -> csrf.disable())


            /** Permit all requests */
            // .authorizeHttpRequests(
            //     authorize -> authorize.antMatchers("/**").permitAll()
            // );


            /**
             * To send login contents from BasicController
             * Uncomment login() from BasicController
             * you should see the response
             *  `This is the custom login page!`
             */
            // .authorizeHttpRequests(
            //     authorize -> authorize
            //         .antMatchers("/actuator/**").permitAll()
            //         .antMatchers("/admin/**").hasRole("ADMIN")
            //         .anyRequest().authenticated()
            // )
            // .formLogin( formLogin -> formLogin.loginPage("/login").permitAll() ) /** Allow access to login page for everyone */
            // .logout(logout -> logout.permitAll());


            /** custom login.html */
            // .authorizeHttpRequests(
            //     authorize -> authorize
            //         .antMatchers("/actuator/**", "/ready", "/login.html").permitAll()
            //         .antMatchers("/admin/**").hasRole("ADMIN")
            //         .anyRequest().authenticated()
            // ).formLogin(
            //     formLogin -> formLogin
            //         .loginPage("/login.html")       // Sendning HTML here
            //         .loginProcessingUrl("/login")   // MANDATORY !!  [Important]
            //         .defaultSuccessUrl("/userHome", true) // Always use /userHome, Not the visited one
            //         .failureUrl("/login?error")
            //         .permitAll()
            // ).logout(  logout -> logout.permitAll()  );




            /** Now let's add CSRF Without Thymleaf template Engine or Custom CSRF filter */
            /** Generally discouraged - Rendering HTML from controller */
            .authorizeHttpRequests(
                authorize -> authorize
                    .antMatchers("/actuator/**", "/ready", "/login.html").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            ).formLogin(
                formLogin -> formLogin
                    .loginPage("/login.html")       // Sendning HTML here
                    .loginProcessingUrl("/login")   // MANDATORY !!  [Important]
                    .defaultSuccessUrl("/userHome", true) // Always use /userHome, Not the visited one
                    .failureUrl("/login?error")
                    .permitAll()
            ).logout(  logout -> logout.permitAll()  );


        return http.build();
    }



    /**
     * Now you can add UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder.encode("Hello123"))
            .roles("USER")
            .build();
        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("Hello123"))
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user, admin); // In Memory User
    }

    /**
     * PasswordEncoder bean is mandatory for UserDetailsService bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * To This will completely bypass any hashing logic
     */
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return NoOpPasswordEncoder.getInstance();
    // }

}


