package com.exmaple.jumbaClass.model;

public class Participant {

	private int id;
	private String name;
	private String email;
	private String phone; 
	private int batchId;
	
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Participant() {
		
	}

	public Participant(int id, String name, String email, String phone, int batchId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.batchId = batchId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + ", phone =" + phone+ ", batchId=" + batchId + "]";
	}
	
	


}
