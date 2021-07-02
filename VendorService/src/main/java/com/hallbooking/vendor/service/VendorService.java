package com.hallbooking.vendor.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.vendor.dao.VendorDao;
import com.hallbooking.vendor.exception.VendorNotFoundException;
import com.hallbooking.vendor.model.Vendor;



@Service("vendorService")
public class VendorService {

	@Autowired
	VendorDao vdao;
	
	public String vendorRegistration(Vendor var)
	{
	
		vdao.save(var);
		return "sucessfullyRegistred";
	}
	public List<Vendor> vendorlist(String city)
	{
		List<Vendor> list = vdao.findVendorByCity(city);
		return list;
	
	}
	public String delete(String id)
	{
		//if(vdao.existsById(id))
		   vdao.deleteById(id);
		
		//else
			//throw new VendorNotFoundException("not founnd");
		return "sucessfullyDeleted";
	}
	
	public String update(Vendor var)
	{
		vdao.save(var);
		return "sucessfullyUpdated";
	}
	
	public Vendor findById(String vid) {
	
		return vdao.findById(vid).get();

		
	}

}
