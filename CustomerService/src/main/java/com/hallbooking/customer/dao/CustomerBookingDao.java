package com.hallbooking.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.customer.model.CustomerBookStatus;

@Repository("cbdao")
public interface CustomerBookingDao extends JpaRepository<CustomerBookStatus,String>  {

}
