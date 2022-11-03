//package com.greatlearning.employee.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.greatlearning.employee.service.UserDetailsServiceImpl;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsServiceImpl();
//
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/h2-console/**");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/api/user", "/api/roles", "/api/employees/delete")
//				.hasAuthority("ADMIN").antMatchers("/api/employees/{employee_id}", "/api/employees/employeeList")
//				.hasAnyAuthority("USER", "ADMIN").antMatchers("/api/employees/add").hasAuthority("ADMIN")
//				.antMatchers("/api/employee/update").hasAuthority("ADMIN").antMatchers("/api/employee/delete/*")
//				.hasAuthority("ADMIN").antMatchers("/api/employee/search/*", "/api/employees/sort/*")
//				.hasAnyAuthority("ADMIN", "USER").antMatchers("/h2-console/**").permitAll().anyRequest().authenticated()
//				.and().formLogin().permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().cors().and()
//				.csrf().disable();
//
//	}
//
//}
