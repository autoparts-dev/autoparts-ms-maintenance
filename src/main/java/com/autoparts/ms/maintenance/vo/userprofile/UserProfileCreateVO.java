/**
 * 
 */
package com.autoparts.ms.maintenance.vo.userprofile;

import java.io.Serializable;

import com.autoparts.core.validator.json.JsonDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.autoparts.core.validator.json.annotation.Regexp;
//import com.fasterxml.jackson.annotation.JsonAlias;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = JsonDeserializeValidator.class)
public class UserProfileCreateVO implements Serializable {

	private String loginId;
	
	@Mandatory
	private String firstName;
	
	private String lastName;

	@Regexp("^\\d{9,11}$")
	@Mandatory
	private String mobileNumber;
	
	@Mandatory
	private String email;
	
//	@Mandatory
	private String companyId;
	
	
	/**
	 * 
	 */
	public UserProfileCreateVO() {
		// TODO Auto-generated constructor stub
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
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


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}



}
