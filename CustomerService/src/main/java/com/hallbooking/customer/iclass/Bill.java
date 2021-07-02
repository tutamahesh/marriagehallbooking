package com.hallbooking.customer.iclass;
public class Bill {
	private String customerId;

	private int billNo;
	
	private double totalBill;

	private String supervisorId;

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
