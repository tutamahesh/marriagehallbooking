package com.hallbooking.vendor.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hallbooking.vendor.model.Vendor;


@Repository("vdao")
public interface VendorDao extends JpaRepository<Vendor,String>{ 
	 List<Vendor> findVendorByCity(String city);

	 
}
	
