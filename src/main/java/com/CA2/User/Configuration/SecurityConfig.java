package com.CA2.User.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
                 .requestMatchers("/register").permitAll()
                 .requestMatchers("/home").permitAll()
          )
          
             .formLogin((form) ->
                 form
                     .loginPage("/login")
                     .loginProcessingUrl("/login")
                     .defaultSuccessUrl("/home", true)
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
