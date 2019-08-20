package com.techsofin.sdccpayment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="org_customer")
public class Customer {
	@Id
	@Column(name="Customer ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	
	@Column(name="Customer Name")
	private String customerName;
	
	@Column(name="Mobile Number")
	private String mobileNumber;
	
	@Column(name="Email ID")
	private String emailId;
	
	@Column(name="Scheme Start Date")
	private String schemestartDate;
	
	@Column(name="Mapped Agent ID")
	private String mappedagentID;
	
	@Column(name="Branch ID")
	private String branchID;
	
	@Column(name="Active/Inactive Flag")
	private String activeFlag;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomer(Integer CustomerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSchemestartDate() {
		return schemestartDate;
	}

	public void setSchemestartDate(String schemestartDate) {
		this.schemestartDate = schemestartDate;
	}

	public String getMappedagentID() {
		return mappedagentID;
	}

	public void setMappedagentID(String mappedagentID) {
		this.mappedagentID = mappedagentID;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	

}
