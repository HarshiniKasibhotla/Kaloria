package com.csci5308.kaloria.access;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * I got this code from
 * https://dzone.com/articles/add-login-to-your-spring-boot-app-in-10-mins
 *
 *This is to ensure that every page on the site requires authentication.  Spring
 * security mechanisms are being used to enforce this. If a user is not authenticated this class will
 * redirect them to login/sign up.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register/**").permitAll()
				.antMatchers("/login/**").permitAll().antMatchers("/registerDietician/**").permitAll()
				.antMatchers("/home/**").permitAll().antMatchers(HttpMethod.POST, "/loginUser/**").permitAll()
				.antMatchers("/styles/**").permitAll().antMatchers("/css/**").permitAll().antMatchers("/js/**")
				.permitAll().antMatchers("/dietSuggestions/**").permitAll().antMatchers("/admin/**").permitAll()
				.antMatchers("/dietician/**").permitAll().antMatchers("/signup/**").permitAll();

//                .authenticated().and().formLogin().loginPage("/").permitAll().and().logout().permitAll();
//                .antMatchers("/signup/**").permitAll().antMatchers("/admin/**").hasRole("ADMIN").anyRequest()

	}

}
