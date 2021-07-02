package com.hallbooking.booking.model;
public class Supervisor {

	private String supervisorId;
	private String hallname;
	private String location;
	private int hallCapacity;
	private int numberOfRooms;
	private String electricalEquipmentDetails;
	private String houseKeepingDetails;
	private double hallPrice;
	private String contactNo;
		
	public Supervisor(String supervisorid, String hallname, String location, int hallCapacity, int numberOfRooms,
			String electricalEquipmentDetails, String houseKeepingDetails, double hallPrice, String contactNo) {
		super();
		this.supervisorId = supervisorid;
		this.hallname = hallname;
		this.location = location;
		this.hallCapacity = hallCapacity;
		this.numberOfRooms = numberOfRooms;
		this.electricalEquipmentDetails = electricalEquipmentDetails;
		this.houseKeepingDetails = houseKeepingDetails;
		this.hallPrice = hallPrice;
		this.contactNo = contactNo;
	}
	public Supervisor() {
		super();
	}
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
	public String getElectricalEquipmentDetails() {
		return electricalEquipmentDetails;
	}
	public void setElectricalEquipmentDetails(String electricalEquipmentDetails) {
		this.electricalEquipmentDetails = electricalEquipmentDetails;
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
	
	
}
