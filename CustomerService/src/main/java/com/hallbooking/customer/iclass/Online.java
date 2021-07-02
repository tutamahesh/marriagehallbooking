package com.hallbooking.customer.iclass;

public class Online {
	private String customerId;
	private int billNo;
	private String hallId;
	private String bookingDate;
	private  String modeOfPayment; 
	private double totalBill;

	public Online(String customerId, int billNo, String hallId, String bookingDate,String modeOfPayment, double totalBill) {
		super();
		this.customerId = customerId;
		this.billNo = billNo;
		this.hallId = hallId;
		this.bookingDate = bookingDate;
		this.totalBill = totalBill;
		this.modeOfPayment=modeOfPayment;
		
	}
	public Online() {
		
	}
	

	
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getHallId() {
		return hallId;
	}
	public void setHallId(String hallId) {
		this.hallId = hallId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	
	
}
