package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class UserSecurityConfig {
	 @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf().disable()
	                .authorizeHttpRequests((requests) -> requests
	                        .requestMatchers("/registration/**").permitAll()
	                        .requestMatchers("/login/**").permitAll()
	                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/adminLogin/**").permitAll()
	                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
	                .formLogin((form) -> form
	                        .loginPage("/login")
	                        .loginPage("/adminLogin")
	                        .loginProcessingUrl("/login")
	                        .defaultSuccessUrl("/user/")
	                        .permitAll()
	                )
	                .logout((logout) -> logout.permitAll())
	                .exceptionHandling().accessDeniedPage("/access-denied");
	        return http.build();
	    }

}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@Order(2)
//public class UserSecurityConfig {
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public SecurityFilterChain homePageSecurityFilterChain(HttpSecurity http) throws Exception {
//		
//		return http
//				   .cors()
//				   .and()
//				   .csrf().disable()
//				   .authorizeHttpRequests()
//				   .requestMatchers("/user/**").hasAuthority("USER")
//				   .and()
//				   .formLogin()
//				   .loginPage("/login")
//				   .defaultSuccessUrl("/user/")
//				   .and()
//				   .authorizeHttpRequests()
//				   .requestMatchers("/**")
//				   .permitAll()
//				   .and()
//				   .formLogin()
//				   .and()
//				   .build();
//	}
//}