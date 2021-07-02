package com.hallbooking.admin.inter;
 public class Vendor {
	
	private String vendorId;
	
	
	private String city;
	
	
	private String typeOfVendor;
	
	
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



