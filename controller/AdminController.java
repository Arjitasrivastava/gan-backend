package com.united.gan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.united.gan.model.Admin;
import com.united.gan.service.AdminService;
import com.united.gan.utils.Constants;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = Constants.ORIGIN, allowedHeaders = "*")
public class AdminController {
	
	@Autowired
	private AdminService service;
		
	@PostMapping("/admin")
	public Admin loginUser(@RequestBody Admin admin) throws Exception {
		String tempEmailId = admin.getEmailId();
		String tempPassword = admin.getPassword();
		Admin validUser = null;
		if(tempEmailId != null && tempPassword != null) {
			validUser = service.fetchAdminByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(validUser == null) {
			throw new Exception("Bad credentials");
		}
		return validUser;	
	}
	
	 @GetMapping("/admin/{adminId}")
	    public Optional<Admin> getUser(@PathVariable(value = "adminId") Integer adminId) {
	        return service.fetchAdminById(adminId);
	    }

}

