package com.hallbooking.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.admin.model.AdminVendor;
@Repository("vendorDao")
public interface VendorDao extends JpaRepository<AdminVendor,String> {

	List<AdminVendor> findVendorByCity(String city);

}
