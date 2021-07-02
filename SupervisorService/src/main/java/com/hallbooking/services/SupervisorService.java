package com.hallbooking.services;

import java.util.List;
import java.util.Optional;

import com.hallbooking.model.Hall;


public interface SupervisorService {
	public void addHallDetails(Hall hall);
	public void modifyHallDetailsById(Hall hall,String supervisorId);
	public String deleteHallDetailsById(String supervisorId);
	public Optional<Hall> getHallDetailsById(String supervisorId);
	public List<Hall> findHallsByLocation(String location);


}
