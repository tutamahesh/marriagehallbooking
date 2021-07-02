package com.hallbooking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hallbooking.model.Hall;
import com.hallbooking.services.SupervisorServiceImpl;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/hall",tags="This is a Supervisor Service Controller")
@RestController
@RequestMapping("/supervisors")
public class SupervisorController {
	@Autowired
	SupervisorServiceImpl supervisorservice;
	
	Logger logger=LoggerFactory.getLogger(SupervisorController.class);
	
	@ApiOperation(value="Insert hall details", response=Hall.class)
	@PostMapping("/add")
	public ResponseEntity<String> addHallDetails(@RequestBody Hall hall) {
		logger.info("Adding Hall Details to the database!!!!");
		supervisorservice.addHallDetails(hall);
		return new ResponseEntity<String>("Hall Details are Added Successfully!!!!!!",HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Update hall details", response=Hall.class)
	@PutMapping("/modify/{supervisorId}")
	public ResponseEntity<String> modifyHallDetails(@RequestBody Hall hall, @PathVariable("supervisorId") String supervisorId) {
		logger.info("Upadating the Hall details!!!!");

		supervisorservice.modifyHallDetailsById(hall, hall.getSupervisorId());
		return new ResponseEntity<String>("Hall Details are Updated Successfully!!!!!!",HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Delete hall details by id", response=Hall.class)
	@DeleteMapping("/delete/{supervisorId}")
	public ResponseEntity<String> deleteHallDetailsById(@PathVariable("supervisorId") String supervisorId)
	{
		logger.info("Deleting the hall details by SupervisorId!!!!");
		
		supervisorservice.deleteHallDetailsById(supervisorId);
		return new ResponseEntity<String>("Hall Details are Added Successfully!!!!!!",HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all hall details", response=Iterable.class)
	@GetMapping("/getAll")
	public List<Hall> getAllHallDetails()
	{
		logger.info("Displaying all hall!!! ");
		
		return supervisorservice.getAllHallDetails();
		
	}
	
	@ApiOperation(value="Get hall details by id", response=Iterable.class)
	@GetMapping("/gethall/{supervisorId}")
	public Optional<Hall> getHallDetailsById(@PathVariable("supervisorId") String supervisorId)
	{
		logger.info("Displying Hall Details by Id");
		
		return supervisorservice.getHallDetailsById(supervisorId);
	}
	
	@ApiOperation(value="Get all halls by Location")
	@GetMapping("/gethalls/{location}")
	public List<Hall> getHallsByLocation(@PathVariable("location") String location){
		return supervisorservice.findHallsByLocation(location);
	}
	


}
