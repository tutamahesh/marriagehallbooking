package com.hallbooking.admin.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hallbooking.admin.dao.VendorDao;
import com.hallbooking.admin.model.AdminVendor;
@Service("vendorSerivce")
public class VendorService {
	
	@Autowired
	VendorDao vendorDao;
	
	public void addVendor(AdminVendor v)
	{
		 vendorDao.save(v);
	
	}
	
	public void deleteVendor(String vendorId) {
		
			vendorDao.deleteById(vendorId);
		
	
		
	}
	
	public void updateVendor(String vendorId,AdminVendor v)
	{
		vendorDao.save(v);

	}
	
	
	public Optional<AdminVendor>  findVendorById(String vendorId)
	{
		
		return vendorDao.findById(vendorId);
	}
	
	public List<AdminVendor> findVendorByCity(String city)
	{	
		return vendorDao.findVendorByCity(city) ;
	}

	public boolean existsById(String vendorId) {
		vendorDao.getById(vendorId);
		return false;
	}

}
