package com.hallbooking.customer.iclass;



		
		public class AdminVendor {

		private String vendorId;
		private String city;
		private String typeOfVendor;
		private double price;
		
		public AdminVendor(String vendorId, String city, String typeOfVendor, double price) {
			super();
			this.vendorId = vendorId;
			this.city = city;
			this.typeOfVendor = typeOfVendor;
			this.price = price;
		}

		public AdminVendor() {super();
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


		public void setTypeOfVendor(String typeOfVendor) {
			this.typeOfVendor = typeOfVendor;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}
		
		
	

}
