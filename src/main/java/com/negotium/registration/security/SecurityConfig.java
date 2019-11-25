package com.negotium.registration.security;

import com.negotium.registration.service.CustomUserDetails;
import com.negotium.registration.service.CustomUserDetailsService;
import com.negotium.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/register", "/all")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.loginPage("/login")
                .successForwardUrl("/success")
                .failureForwardUrl("/errorPage")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
