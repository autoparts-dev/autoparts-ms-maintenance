/**
 * 
 */
package com.autoparts.ms.maintenance.vo.user;

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
public class UserProfileUpdateVO implements Serializable{

	@BindVariable
	@Mandatory
	private String id;
	
	@BindVariable
	@Mandatory
	private String firstName;
	
	@BindVariable
	private String lastName;
	
	@BindVariable
	@Mandatory
	@Regexp("^\\d{9,11}$")
	private String mobileNumber;
	
	@BindVariable
	@Regexp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	
	
	@BindVariable
	@JsonIgnore
	private String status;
	
	@BindVariable
	@JsonIgnore
	private String updatedBy;
	
	@BindVariable
	@JsonIgnore
	private Date updated;
	
	@BindVariable
	@JsonIgnore
	private String delete;
	/**
	 * 
	 */
	public UserProfileUpdateVO() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String isDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

}
