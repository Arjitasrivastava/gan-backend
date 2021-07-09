package com.united.gan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.united.gan.model.User;
import com.united.gan.service.MailService;
import com.united.gan.service.RegistrationService;
import com.united.gan.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = Constants.ORIGIN, allowedHeaders = "*")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private MailService mail = new MailService();
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempEmailId =user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User existingUser = service.fetchUserByEmailId(tempEmailId);
			if(existingUser != null) {
				throw new Exception("User with "+tempEmailId+" already exist");
			}
		}
		
		User userObj = null;
		userObj = service.saveUser(user);
		String mailResponse = mail.sendMail(userObj, Constants.registerHeading);
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User validUser = null;
		if(tempEmailId != null && tempPassword != null) {
			validUser = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(validUser == null) {
			throw new Exception("Bad credentials");
		}
		return validUser;	
	}
	
	@PostMapping("/forgot")
	public void loginUser(@RequestBody String toMailID) throws Exception {
		if(toMailID != null && !"".equals(toMailID)) {
			User existingUser = service.fetchUserByEmailId(toMailID);
			if(existingUser != null) {
				String mailResponse = mail.sendMail(existingUser, Constants.forgotHeading);
			}else {
				throw new Exception("user with "+toMailID+" doesn't exist");
			}
		}
	}
}

