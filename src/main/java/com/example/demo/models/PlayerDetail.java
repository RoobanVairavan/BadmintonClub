package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_details")
public class PlayerDetail {
	
	@Id
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "account_balance")
	private double accountBalance;

	// constructors, getters, and setters

	public PlayerDetail(String phoneNumber, String name, double accountBalance) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.accountBalance = accountBalance;
	}

	public PlayerDetail() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
