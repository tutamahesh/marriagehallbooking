package com.hallbooking.services;


import java.util.Optional;

import com.hallbooking.model.Bill;
import com.hallbooking.model.CustomerBookStatus;

public interface BillingService {
	public void addBillingAmount(CustomerBookStatus cbs);
	public Optional<Bill> getBill(String customerId);
	public Optional<Bill> getBillByBillNo(int billNo);
	
}
