package com.CA2.User.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 @Autowired
 CustomUserDetailsService customUserDetailsService;

 @Bean
 public static PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	//return NoOpPasswordEncoder.getInstance();   //Using NoOpPasswordEncoder for plain text password comparison
 }
 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http.csrf().disable()
             .authorizeHttpRequests((authorize) ->
             authorize
             
                // Ensure root URL is permitted
                 .requestMatchers("/").permitAll() 
                 
                 
                 .requestMatchers("/favicon.ico").permitAll()

          		.requestMatchers("/registerGet").permitAll() // get 'Register' page
          		.requestMatchers("/registerPost").permitAll() // renders the action post form > 'Register' page 
          		
          		.requestMatchers("/login").permitAll()
          		
          
                 // it Authorizes all the STATIC folder and files in it using '/**'
                .requestMatchers("/styles/**").permitAll()
         		.requestMatchers("/images/**").permitAll()
         		.requestMatchers("/js/**").permitAll()
         		
         		 // Ensure only authenticated users can access the dashboard
         		.requestMatchers("/dashboard").authenticated()
         		.requestMatchers("/addData/**").authenticated()// Permit all endpoints starting with "/addData"
                  		
          )
             
             .formLogin((form) ->
                 form
                     .loginPage("/login")
                     .loginProcessingUrl("/login")
                     .defaultSuccessUrl("/dashboard", true)
                     .permitAll()
             )
             
             .logout((logout) ->
                 logout
                     .invalidateHttpSession(true)
                     .clearAuthentication(true)
                     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                     .logoutSuccessUrl("/login?logout")
                     .permitAll()
                     
                     
             );

     return http.build();
 }

 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

 }
 }
