/**
 * 
 */
package com.autoparts.ms.maintenance.vo.companyprofile;

import java.io.Serializable;

import com.autoparts.core.validator.json.JsonDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.autoparts.core.validator.json.annotation.Regexp;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = JsonDeserializeValidator.class)
public class CompanyProfileUpdateVO implements Serializable {

	@Mandatory
	private String id;
	
	@Mandatory
	private String name;
	
//	@JsonAlias("brn")	// deserialise
//	@JsonProperty("brn")	// serialise
//	@Mandatory
//	private String businessRegistrationNumber;
	
	@Regexp("^\\d{9,11}$")
	private String contactNumber;
	
	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	private String postcode;

	private String stateId;

	private String countryId;
	
	/**
	 * 
	 */
	public CompanyProfileUpdateVO() {
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



	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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




}
