package com.hallbooking.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.customer.model.Customer;
@Repository("cdao")
public interface CustomerDao extends JpaRepository<Customer,String>{

}
