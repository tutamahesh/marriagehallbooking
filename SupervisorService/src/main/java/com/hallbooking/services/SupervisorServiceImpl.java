
package com.hallbooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.dao.SupervisorRepository;
import com.hallbooking.exceptions.IdNotFoundException;
import com.hallbooking.model.Hall;

@Service("supervisorservice")
public class SupervisorServiceImpl implements SupervisorService {
	String str="SupervisorId does not exists in table...Give correct supervisor Id";
	@Autowired
	private SupervisorRepository supervisorRepository;
	
	public void addHallDetails(Hall hall)
	{
		supervisorRepository.save(hall);
	
	}
	
	public void modifyHallDetailsById(Hall hall, String supervisorId)
	{
		if(!supervisorRepository.existsById(supervisorId))
		{
			throw new IdNotFoundException(str);
		}
		supervisorRepository.save(hall);
	}
	
	public String deleteHallDetailsById(String supervisorId)
	{
		if(!supervisorRepository.existsById(supervisorId))
		{
			throw new IdNotFoundException(str);
		}
		supervisorRepository.deleteById(supervisorId);
		return supervisorId;
	}
	
	
	public List<Hall> getAllHallDetails()
	{
		return supervisorRepository.findAll();
	}
	
	public Optional<Hall> getHallDetailsById(String supervisorId)
	{
		if(!supervisorRepository.existsById(supervisorId))
		{
			throw new IdNotFoundException(str);
		}
		return supervisorRepository.findById(supervisorId);
	}

	@Override
	public List<Hall> findHallsByLocation(String location) {
		return supervisorRepository.findByLocation(location);
		
	}
		

	
	
	
}

