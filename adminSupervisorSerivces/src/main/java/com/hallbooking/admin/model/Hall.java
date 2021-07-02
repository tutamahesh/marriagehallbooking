package com.hallbooking.admin.model;

import io.swagger.annotations.ApiModelProperty;


public class Hall {
	@ApiModelProperty(notes="Id of the supervisor", name="id",required=true)
	private String supervisorId;
	@ApiModelProperty(notes="Hallname", name="hallname",required=true)
	private String hallname;
	@ApiModelProperty(notes="Location of Hall", name="location",required=true)
	private String location;
	@ApiModelProperty(notes="Number of peoples get space in Hall", name="hallCapacity",required=true)
	private int hallCapacity;
	@ApiModelProperty(notes="Number of rooms there in Hall", name="numberOfRooms",required=true)
	private int numberOfRooms;
	@ApiModelProperty(notes="information regarding electricalEquiptment there in Hall", name="electricalEquiptmentDetails",required=true)
	private String electricalEquiptmentDetails;
	@ApiModelProperty(notes="Information regarding houseKeeping ", name="houseKeepingDetails",required=true)
	private String houseKeepingDetails;
	@ApiModelProperty(notes="Price of Hall", name="hallPrice",required=true)
	private double hallPrice;
	@ApiModelProperty(notes="contactNo of the supervisor", name="contactNo",required=true)
	private String contactNo;
	
	
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getHallname() {
		return hallname;
	}
	public void setHallname(String hallname) {
		this.hallname = hallname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(int hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public String getElectricalEquiptmentDetails() {
		return electricalEquiptmentDetails;
	}
	public void setElectricalEquiptmentDetails(String electricalEquiptmentDetails) {
		this.electricalEquiptmentDetails = electricalEquiptmentDetails;
	}
	public String getHouseKeepingDetails() {
		return houseKeepingDetails;
	}
	public void setHouseKeepingDetails(String houseKeepingDetails) {
		this.houseKeepingDetails = houseKeepingDetails;
	}
	public double getHallPrice() {
		return hallPrice;
	}
	public void setHallPrice(double hallPrice) {
		this.hallPrice = hallPrice;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public Hall(String supervisorId, String hallname, String location, int hallCapacity, int numberOfRooms,
			String electricalEquiptmentDetails, String houseKeepingDetails, double hallPrice, String contactNo) {
		super();
		this.supervisorId = supervisorId;
		this.hallname = hallname;
		this.location = location;
		this.hallCapacity = hallCapacity;
		this.numberOfRooms = numberOfRooms;
		this.electricalEquiptmentDetails = electricalEquiptmentDetails;
		this.houseKeepingDetails = houseKeepingDetails;
		this.hallPrice = hallPrice;
		this.contactNo = contactNo;
	}
	public Hall() {
		
	}
	
}
