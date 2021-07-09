package com.united.gan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.united.gan.model.User;
import com.united.gan.repository.RegistrationRepository;
import com.united.gan.utils.PasswordGenerator;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
		        .useDigits(true)
		        .useLower(true)
		        .useUpper(true)
		        .build();
		String password = passwordGenerator.generate(8);
		user.setPassword(password);
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return repo.findByEmailIdAndPassword(emailId, password);
	}

}

