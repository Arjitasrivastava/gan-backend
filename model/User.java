package com.united.gan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User extends AuditModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	
	@Column(nullable = false, unique=true)
	private String emailId;
	
	@Column(nullable = false, length=15)
	private long telephone;
	
	@Column(nullable = false)
	private String addressOne;
	
	@Column(nullable = true)
	private String addressTwo;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private long zip;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = true)
	private String password;
	
	
	public User() {
	}

	public User(int id, String firstName, String lastName, String emailId,
			long telephone, String addressOne, String addressTwo, String city, String state, long zip, String country,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.emailId = emailId;
		this.telephone = telephone;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

