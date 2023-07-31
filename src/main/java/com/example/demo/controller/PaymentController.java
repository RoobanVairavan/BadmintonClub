package com.example.demo.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PaymentService;
import com.example.demo.models.PaymentDetail;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	// Create Payment Details
		@PostMapping("/phoneNumber/amount_paid")
		public ResponseEntity<?> addPayment(@RequestParam("playerPhoneNumber") String playerPhoneNumber,
				@RequestParam("amountPaid") String amountPaid) {
			double d = Double.valueOf(amountPaid);
			LocalDateTime datetime = LocalDateTime.now();
			PaymentDetail payment = new PaymentDetail(playerPhoneNumber, datetime, d);
			PaymentDetail success = paymentService.updatePayment(payment);
			if (success != null) {
				return new ResponseEntity<>(success, HttpStatus.CREATED);
			} else {
				String errorMessage = "Failed To Add Payment.";
				return ResponseEntity.badRequest().body(errorMessage);
			}
		}
		
		
	// Getting Payments Based on the player Mobile Number
	@GetMapping("/phoneNumber")
	public ResponseEntity<?> getPayments(@RequestParam("phoneNumber") String phoneNumber) {
		PaymentDetail payment = paymentService.getPaymentDetailByUser(phoneNumber);
		if(payment != null)
		{
			return new ResponseEntity<>(payment, HttpStatus.FOUND);
		}
		else {
			String errorMessage = "Nothing Have To Get!.";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

	
}
