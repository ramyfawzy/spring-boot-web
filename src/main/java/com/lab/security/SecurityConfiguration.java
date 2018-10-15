/**
 * 
 */
package com.lab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.lab.configuration.AuthenticationEntryPointImpl;
import com.lab.configuration.CustomAccessDeniedHandler;

/**
 * @author Ramy
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//    	 httpSecurity.authorizeRequests().antMatchers("/blank").permitAll();
//    	httpSecurity
//         .authorizeRequests()
//         .antMatchers("/css/**").permitAll();
//    	httpSecurity
//        .authorizeRequests()http.exceptionHandling().authenticationEntryPoint(...)
//        .antMatchers("/images/**").permitAll()
//        .antMatchers("/js/**").permitAll()
//         .anyRequest().authenticated();
//        httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//        httpSecurity.authorizeRequests().antMatchers("/").denyAll();
//    	httpSecurity.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
    
    

}
