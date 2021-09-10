package ru.gb.auth.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAuthentication extends WebSecurityConfigurerAdapter {

    //   For BCrypt Encoded password
 //   @Bean
 //   public PasswordEncoder passwordEncoder() {
 //       PasswordEncoder encoder = new BCryptPasswordEncoder();
 //       return encoder;
 //   }

    //   For no Encoder, plain text password
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

}
