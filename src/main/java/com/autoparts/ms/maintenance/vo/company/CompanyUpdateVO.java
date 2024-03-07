/**
 * 
 */
package com.autoparts.ms.maintenance.vo.company;

import java.io.Serializable;
import java.util.Date;

import com.autoparts.core.entity.annotation.BindVariable;
import com.autoparts.core.validator.json.RootDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.autoparts.core.validator.json.annotation.Regexp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = RootDeserializeValidator.class)
public class CompanyUpdateVO implements Serializable {

	@BindVariable
	@Mandatory
	private String id;
	
	@BindVariable
	@Mandatory
	private String name;
	
	@BindVariable(name = "brn")
	@Mandatory
	private String businessRegisrationNumber;
	
	@BindVariable
	@Regexp("^\\d{9,11}$")
	private String contactNumber;
	
	@BindVariable
	private String addressLine1;

	@BindVariable
	private String addressLine2;

	@BindVariable
	private String addressLine3;

	@BindVariable
	private String postcode;

	@BindVariable
	private String stateId;

	@BindVariable
	private String countryId;
	
	@JsonIgnore
	@BindVariable
	private Date updated;
	
	@JsonIgnore
	@BindVariable
	private String updatedBy;
	
	@BindVariable
	@JsonIgnore
	private String status;
	
	@BindVariable
	@JsonIgnore
	private String delete;
	

	/**
	 * 
	 */
	public CompanyUpdateVO() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String isDelete() {
		return delete;
	}


	public void setDelete(String delete) {
		this.delete = delete;
	}



}
