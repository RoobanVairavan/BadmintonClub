package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_details")
public class PaymentDetail {
	@Id
	@Column(name = "player_phone_number")
	private String playerPhoneNumber;

	@Column(name = "date_of_payment")
	private LocalDateTime dateOfPayment;

	@Column(name = "amount_paid")
	private double amountPaid;

	// Constructor, Getters & Setters
	public PaymentDetail(String playerPhoneNumber, LocalDateTime dateOfPayment, double amountPaid) {
		super();
		this.playerPhoneNumber = playerPhoneNumber;
		this.dateOfPayment = dateOfPayment;
		this.amountPaid = amountPaid;
	}

	public String getPlayerPhoneNumber() {
		return playerPhoneNumber;
	}

	public void setPlayerPhoneNumber(String playerPhoneNumber) {
		this.playerPhoneNumber = playerPhoneNumber;
	}

	public LocalDateTime getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDateTime dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public PaymentDetail() {
		super();
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

}
