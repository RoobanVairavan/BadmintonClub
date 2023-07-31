package com.example.demo.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PaymentDetail;

public interface PaymentRepo extends JpaRepository<PaymentDetail, String> {
	
}
