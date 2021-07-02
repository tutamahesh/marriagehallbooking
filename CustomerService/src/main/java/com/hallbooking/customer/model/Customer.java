package com.hallbooking.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="This Is A Customer Model")
@Entity
@Table(name="cust")
public class Customer {
	@ApiModelProperty(value="This Is Customer Id Property")
	@Id
	@NotNull(message="Id Should not be null")
	private String customerId;
	
	@ApiModelProperty(value="This is Customer Name Property")
	@NotNull(message="Name should not be Null")
	private String customerName;
	
	@ApiModelProperty(value="This Is Customer Contact No Property")
	@NotNull(message="Contact no should not be Null")
	
	private String customerContactNo;
	

	public Customer(String customerId, String customerName, String customerContactNo) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerContactNo() {
		return customerContactNo;
	}


	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}


	public Customer() {
		
	}

	

}
