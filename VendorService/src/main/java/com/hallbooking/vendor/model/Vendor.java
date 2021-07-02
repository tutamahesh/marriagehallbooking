package com.hallbooking.vendor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
 public class Vendor {
	@Id
	@ApiModelProperty(notes = "ID of the Vendor", name = "id", required = true, value = "234567")
	private String vendorId;
	
	@ApiModelProperty(notes = "City of the Vendor", name = "city", required = true, value = "visakhapatnam")
	private String city;
	
	@ApiModelProperty(notes = "Type of the Vendor", name = "typeOfVendor", required = true, value = "DJ")
	private String typeOfVendor;
	
	@ApiModelProperty(notes = "Price of the Vendor", name = "price", required = true, value = "50000")
	private double price;
	
	public Vendor(String vendorId, String city, String typeOfVendor, double price) {
		super();
		this.vendorId = vendorId;
		this.city = city;
		this.typeOfVendor = typeOfVendor;
		this.price = price;
	}
	
	public Vendor() {
		
	}

	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTypeOfVendor() {
		return typeOfVendor;
	}
	public void setTypeOfVendor(String typeofvendor) {
		this.typeOfVendor = typeofvendor;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", city=" + city + ", typeOfVendor=" + typeOfVendor + ", price=" + price
				+ "]";
	}
	


   
	

}



