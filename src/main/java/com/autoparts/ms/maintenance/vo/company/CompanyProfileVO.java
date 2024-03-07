/**
 * 
 */
package com.autoparts.ms.maintenance.vo.company;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.autoparts.core.entity.annotation.BindVariable;

/**
 * @author sosseres
 *
 */
@Entity
public class CompanyProfileVO implements Serializable {

	@Id
	@Column(name = "ID")
	@BindVariable
	private String id;
	
	@Column(name = "NAME")
	@BindVariable
	private String name;
	
	@Column(name = "BRN")
	@BindVariable(name = "brn")
	private String businessRegisrationNumber;
	
	@Column(name = "STATUS")
	private String status;

	@Column(name = "CONTACT_NUM")
	private String contactNumber;
	
	@Column(name = "ADDR_LINE_1")
	private String addressLine1;

	@Column(name = "ADDR_LINE_2")
	private String addressLine2;

	@Column(name = "ADDR_LINE_3")
	private String addressLine3;

	@Column(name = "POSTCODE")
	private String postcode;

	@Column(name = "MT_STATE_ID")
	private String stateId;


	@Column(name = "MT_CTRY_ID")
	private String countryId;
	
	@Column(name = "STATE")
	private String state;
	
	
	@Column(name = "COUNTRY")
	private String country;
	
	/**
	 * 
	 */
	public CompanyProfileVO() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBusinessRegisrationNumber() {
		return businessRegisrationNumber;
	}


	public void setBusinessRegisrationNumber(String businessRegisrationNumber) {
		this.businessRegisrationNumber = businessRegisrationNumber;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getAddressLine3() {
		return addressLine3;
	}


	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getStateId() {
		return stateId;
	}


	public void setStateId(String stateId) {
		this.stateId = stateId;
	}


	public String getCountryId() {
		return countryId;
	}


	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
