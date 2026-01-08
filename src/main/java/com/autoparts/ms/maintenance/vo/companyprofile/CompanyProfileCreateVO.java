/**
 * 
 */
package com.autoparts.ms.maintenance.vo.companyprofile;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.autoparts.core.validator.json.JsonDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.autoparts.core.validator.json.annotation.Regexp;
import com.autoparts.ms.maintenance.validator.BusinessDivisionConstraint;
import com.autoparts.ms.maintenance.validator.PartyCodeConstraint;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = JsonDeserializeValidator.class)
public class CompanyProfileCreateVO implements Serializable {

//	@JsonInclude(value = Include.NON_NULL)
//	private String id;
	
	@Mandatory
	private String name;
	
	@JsonAlias("brn")	// deserialise
	@JsonProperty("brn")	// serialise
	private String businessRegistrationNumber;

	@Regexp("^\\d{9,11}$")
	private String contactNumber;
	
	@Mandatory
	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	@Mandatory
	private String postcode;

	@Mandatory
	private String stateId;

	@Mandatory
	private String countryId;
	
	@Mandatory
	@PartyCodeConstraint
	@NotEmpty
	private String partyCode;
	
	@Mandatory
	@BusinessDivisionConstraint
	private String businessDivision;
	
	/**
	 * 
	 */
	public CompanyProfileCreateVO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessRegistrationNumber() {
		return businessRegistrationNumber;
	}


	public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
		this.businessRegistrationNumber = businessRegistrationNumber;
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

	public String getBusinessDivision() {
		return businessDivision;
	}

	public void setBusinessDivision(String businessDivision) {
		this.businessDivision = businessDivision;
	}




}
