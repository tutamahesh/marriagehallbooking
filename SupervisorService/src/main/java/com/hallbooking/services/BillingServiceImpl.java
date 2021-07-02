package com.hallbooking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.dao.BillingRepository;
import com.hallbooking.exceptions.IdNotFoundException;
import com.hallbooking.model.Bill;
import com.hallbooking.model.CustomerBookStatus;
@Service("billingService")
public class BillingServiceImpl implements BillingService  {
	@Autowired
	BillingRepository billingRepository;
	@Override
	public void addBillingAmount(CustomerBookStatus cbs) {
			if(cbs!=null)
			{
				double total=cbs.getHallPrice()+cbs.getVendor1Price()+cbs.getVendor2Price()+cbs.getVendor3Price()+cbs.getVendor4Price();
				Bill b=new Bill();
				b.setCustomerId(cbs.getCustomerId());
				b.setTotalBill(total);
				b.setSupervisorId(cbs.getSupervisorId());
				b.setDate(cbs.getBookingDate());
				billingRepository.save(b);
			}
			else
			{
				throw new NullPointerException();
			}
	}

	@Override
	public Optional<Bill> getBill(String customerId) {
		if(!billingRepository.existsById(customerId))
		{
			throw new IdNotFoundException("CustomerId does not exists in table...Give correct customer Id");
		}
		return billingRepository.findByCustomerId(customerId);
		
	}

	@Override
	public Optional<Bill> getBillByBillNo(int billNo) {
		
		return billingRepository.findByBillNo(billNo);
	}

}
