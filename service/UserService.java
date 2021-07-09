package com.united.gan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.united.gan.model.Admin;
import com.united.gan.model.User;
import com.united.gan.repository.AdminRepository;
import com.united.gan.repository.RegistrationRepository;


@Service
public class UserService implements UserDetailsService {
    
	@Autowired
	private RegistrationRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Admin admin = adminRepository.findByEmailId(email);
    	if(admin == null) {
    		User user = userRepository.findByEmailId(email); 
    		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), new ArrayList<>());	
    	}else {
    		return new org.springframework.security.core.userdetails.User(admin.getEmailId(), admin.getPassword(), new ArrayList<>());	
    	}

    }
}
    
    

 


