package com.hallbooking.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="This Is A Booking Model")
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="This Is BookingNo Property")
	private int bookingNo;
	@ApiModelProperty(value="This Is date of Booking Property")
	private String bookingDate;
	@ApiModelProperty(value="This Is Supervisor/hall ID Property")//yyy-mm-dd
	private String supervisorId;
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public Booking( String supervisorId,String bookingDate) {
		this.bookingDate = bookingDate;
		this.supervisorId = supervisorId;
	}
	public Booking() {
		
	}
	
	

}
