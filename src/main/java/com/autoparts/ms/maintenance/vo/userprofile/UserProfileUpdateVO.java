/**
 * 
 */
package com.autoparts.ms.maintenance.vo.userprofile;

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
public class UserProfileUpdateVO implements Serializable{

	@Mandatory
	private String id;
	
	@Mandatory
	private String firstName;
	
	private String lastName;
	
//	@Mandatory
//	@Regexp("^\\d{9,11}$")
//	private String mobileNumber;
	
	@Regexp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	
	
//	@BindVariable
//	@JsonIgnore
//	private String statusId;
//	
//	@BindVariable
//	@JsonIgnore
//	private String updatedBy;
//	
//	@BindVariable
//	@JsonIgnore
//	private Date updated;
//	
//	@BindVariable
//	@JsonIgnore
//	private String delete;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
