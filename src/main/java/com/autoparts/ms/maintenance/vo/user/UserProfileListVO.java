/**
 * 
 */
package com.autoparts.ms.maintenance.vo.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.autoparts.core.entity.annotation.BindVariable;
import com.autoparts.core.entity.mysql.PageObject;
import com.autoparts.core.validator.json.RootDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = RootDeserializeValidator.class)
@Entity
public class UserProfileListVO extends PageObject implements Serializable{

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@BindVariable
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MOBILE_NUM")
	private String mobileNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Mandatory
	@BindVariable
	@Column(name = "COMPANY_ID")
	private String companyId;
	
	@Column(name = "STATUS")
	private String status;
	
	
	/**
	 * 
	 */
	public UserProfileListVO() {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
