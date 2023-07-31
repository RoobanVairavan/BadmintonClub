package com.example.demo.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PaymentDetail;
import com.example.demo.models.PlayerDetail;
import com.example.demo.repos.PaymentRepo;
import com.example.demo.repos.PlayerDetailRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private PlayerDetailRepo playerDetailRepo;

	public PaymentDetail createPayment(PaymentDetail payment)
	{
		return paymentRepo.save(payment);
	}
	
	
	public PaymentDetail updatePayment(PaymentDetail Payment) {
		
		PaymentDetail payment = this.createPayment(Payment);
		String phoneNumber = payment.getPlayerPhoneNumber();
		Double amountPaid = payment.getAmountPaid();

		PlayerDetail player = playerDetailRepo.findById(phoneNumber).get();
		

		if (player == null) {
			throw new IllegalArgumentException("Player with phone number " + phoneNumber + " not found.");
		} else {
			// Getting Systems Current Time
			LocalDateTime now = LocalDateTime.now();
			payment.setDateOfPayment(now);
			payment.setAmountPaid(amountPaid);
			paymentRepo.save(payment);

			// Reduce(Update) The Amount Player What he/she Paid Now
			player.setAccountBalance(player.getAccountBalance() - amountPaid);
			playerDetailRepo.save(player);
			return payment;
		}
	}

	public PaymentDetail getPaymentDetailByUser(String phoneNumber) {
		return paymentRepo.findById(phoneNumber).get();
	}

}
