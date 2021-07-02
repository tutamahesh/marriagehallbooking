package com.hallbooking.booking.model;




public class Hall {
	
	private String supervisorId;
	private String hallname;
	private String location;
	private int hallCapacity;
	private int numberOfRooms;
	private String electricalEquiptmentDetails;
	private String houseKeepingDetails;
	private double hallPrice;
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
