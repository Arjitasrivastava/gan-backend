package com.united.gan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.united.gan.model.Admin;
import com.united.gan.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repo;

	public Admin fetchAdminByEmailIdAndPassword(String emailId, String password) {
		return repo.findByEmailIdAndPassword(emailId, password);
	}
	
	public Optional<Admin> fetchAdminById(int adminId) {
		return repo.findById(adminId);
	}
	
	public Admin fetchAdminByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}
	

}

