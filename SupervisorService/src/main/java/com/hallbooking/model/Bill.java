package com.hallbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Bill {
	
	@Id
	@ApiModelProperty(notes="Id of the Customer")
	private String customerId;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billNo;
	@ApiModelProperty(notes="Total Bill of Hall with other vendor facility ", name="customerId",required=true)
	private double totalBill;
	@ApiModelProperty(notes="Id of the Supervisor", name="supervisorId",required=true)
	private String supervisorId;
	@ApiModelProperty(notes="hall Booking date", name="date",required=true)
	private String date;
	public int getBillNo() {
		return billNo;
	}
	
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Bill(int billNo, String customerId, double totalBill, String supervisorId, String date) {
		super();
		this.billNo = billNo;
		this.customerId = customerId;
		this.totalBill = totalBill;
		this.supervisorId = supervisorId;
		this.date= date;
	}
	public Bill() {
	
	}
	
	
}
