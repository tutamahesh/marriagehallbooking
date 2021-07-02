package com.hallbooking.admin.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hallbooking.admin.dao.SupervisorDao;
import com.hallbooking.admin.exception.IDNotFoundException;
import com.hallbooking.admin.model.Supervisor;
@Service("sserv")
public class SupervisorService {
	@Autowired
	SupervisorDao sdao;
	
	public void addSupervisor(Supervisor s)
	{
		sdao.save(s);
		
	}

	public String deleteSupervisor(String supervisorId) {
		if(sdao.existsById(supervisorId))
			sdao.deleteById(supervisorId);
		else 
			throw new IDNotFoundException("Record Not Found For Supervisor Id : "+supervisorId);
		return supervisorId;
		
	}
	
	public String updateSupervisor(String supervisorId,Supervisor s)
	{
		sdao.save(s);
		return "Supervisor Updated With Id"+ supervisorId;
	}

	public Optional<Supervisor>  findSupervisorById(String supervisorId)
	{
		if(!sdao.existsById(supervisorId))
		{
			throw new IDNotFoundException("Record Not Found For Supervisor Id : "+supervisorId);
		}
		return sdao.findById(supervisorId);
	}
	
	public List<Supervisor> findSupervisorByLocation(String location)
	{
		return sdao.findSupervisorByLocation(location) ;
	}
	
	public List<Supervisor> findSupervisor(){
		return sdao.findAll();
	}
	
}
