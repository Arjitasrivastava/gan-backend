package com.united.gan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.united.gan.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByEmailIdAndPassword(String emailId, String password);
	public Admin findByEmailId(String emailId);

}

