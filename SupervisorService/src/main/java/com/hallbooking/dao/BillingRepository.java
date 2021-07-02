package com.hallbooking.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.model.Bill;

@Repository("billingRepossitory")
public interface BillingRepository extends JpaRepository<Bill,String>{

	Optional<Bill> findByCustomerId(String customerId);
	Optional<Bill> findByBillNo(int billNo);


}
