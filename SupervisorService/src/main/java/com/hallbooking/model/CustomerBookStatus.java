package com.hallbooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bstatus")
public class CustomerBookStatus {
	@Id
	private String supervisorId;
	private String bookingDate;
	private String customerId;
	private double hallPrice;
	private String vendor1Id;
	private double vendor1Price;
	private String vendor2Id;
	private double vendor2Price;
	private String vendor3Id;
	private double vendor3Price;
	private String vendor4Id;
	private double vendor4Price;
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getHallPrice() {
		return hallPrice;
	}
	public void setHallPrice(double hallPrice) {
		this.hallPrice = hallPrice;
	}
	public String getVendor1Id() {
		return vendor1Id;
	}
	public void setVendor1Id(String vendor1Id) {
		this.vendor1Id = vendor1Id;
	}
	public double getVendor1Price() {
		return vendor1Price;
	}
	public void setVendor1Price(double vendor1Price) {
		this.vendor1Price = vendor1Price;
	}
	public String getVendor2Id() {
		return vendor2Id;
	}
	public void setVendor2Id(String vendor2Id) {
		this.vendor2Id = vendor2Id;
	}
	public double getVendor2Price() {
		return vendor2Price;
	}
	public void setVendor2Price(double vendor2Price) {
		this.vendor2Price = vendor2Price;
	}
	public String getVendor3Id() {
		return vendor3Id;
	}
	public void setVendor3Id(String vendor3Id) {
		this.vendor3Id = vendor3Id;
	}
	public double getVendor3Price() {
		return vendor3Price;
	}
	public void setVendor3Price(double vendor3Price) {
		this.vendor3Price = vendor3Price;
	}
	public String getVendor4Id() {
		return vendor4Id;
	}
	public void setVendor4Id(String vendor4Id) {
		this.vendor4Id = vendor4Id;
	}
	public double getVendor4Price() {
		return vendor4Price;
	}
	public void setVendor4Price(double vendor4Price) {
		this.vendor4Price = vendor4Price;
	}
	public CustomerBookStatus(String supervisorId, String bookingDate, String customerId, double hallPrice,
			String vendor1Id, double vendor1Price, String vendor2Id, double vendor2Price, String vendor3Id,
			double vendor3Price, String vendor4Id, double vendor4Price) {
		super();
		this.supervisorId = supervisorId;
		this.bookingDate = bookingDate;
		this.customerId = customerId;
		this.hallPrice = hallPrice;
		this.vendor1Id = vendor1Id;
		this.vendor1Price = vendor1Price;
		this.vendor2Id = vendor2Id;
		this.vendor2Price = vendor2Price;
		this.vendor3Id = vendor3Id;
		this.vendor3Price = vendor3Price;
		this.vendor4Id = vendor4Id;
		this.vendor4Price = vendor4Price;
	}
	public CustomerBookStatus() {
		
	}
	
	
	
}