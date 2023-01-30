package com.microservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity.csrf().disable()
                 .authorizeHttpRequests()
                 .anyRequest()
                 .permitAll()
                 .and()
                 .httpBasic() ;
         return httpSecurity.build() ;

    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("eureka")
                .password(passwordEncoder().encode("password"))
                .authorities("USER")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user) ;
    }

    @Bean
   public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
}
