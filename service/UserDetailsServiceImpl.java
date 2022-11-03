package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employee.model.User;
import com.greatlearning.employee.repository.UserRepository;
import com.greatlearning.employee.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository ;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepository.getUserByUsername(username) ;
		if(user == null) 
			throw new UsernameNotFoundException("Could not find user with given name");
		return new MyUserDetails(user);
	}

}
