/**
 * 
 */
package com.autoparts.ms.maintenance.vo.companyprofile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sosseres
 *
 */
@Entity
public class CompanyProfileVO implements Serializable {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "BRN")
	@JsonProperty("brn")	// serialise
	private String businessRegistrationNumber;
	
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

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PARTY_CD")
	private String partyCode;
	
	@Column(name = "IS_SELLER_ENABLED")
	private String sellerEnabled;
	
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


	public String getBusinessRegistrationNumber() {
		return businessRegistrationNumber;
	}


	public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
		this.businessRegistrationNumber = businessRegistrationNumber;
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


	public String getPartyCode() {
		return partyCode;
	}


	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}


	public String getSellerEnabled() {
		return sellerEnabled;
	}


	public void setSellerEnabled(String sellerEnabled) {
		this.sellerEnabled = sellerEnabled;
	}

}
