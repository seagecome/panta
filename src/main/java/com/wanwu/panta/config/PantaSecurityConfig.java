package com.wanwu.panta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.wanwu.panta.manager.PantaSecurityInterceptor;
import com.wanwu.panta.manager.PantaUserDetailsService;

@Configuration
@EnableWebSecurity
public class PantaSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PantaSecurityInterceptor pantaSecurityInterceptor;
	
	private final UserDetailsService pantaUserDetailsService;
	
	public PantaSecurityConfig(PantaUserDetailsService pantaUserDetailsService) {
		this.pantaUserDetailsService = pantaUserDetailsService;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(pantaUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/static/**","/boot/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login.page")
		.loginProcessingUrl("/login/check")
		.defaultSuccessUrl("/loginSuccess.page")
		.failureUrl("/loginFail.page")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		http.csrf().disable();
		http.addFilterBefore(pantaSecurityInterceptor, FilterSecurityInterceptor.class);
		http.exceptionHandling().accessDeniedPage("/accessDenied.page");
	}
	
	
}
