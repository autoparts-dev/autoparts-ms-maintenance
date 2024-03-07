/**
 * 
 */
package com.autoparts.ms.maintenance.vo.user;

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
public class UserProfileVO implements Serializable{

	@Id
	@Column(name = "ID")
	@BindVariable
	private String id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOBILE_NUM")
	private String mobileNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COMPANY_ID")
	private String companyId;
	
	@Column(name = "COMPANY_NM")
	private String companyName;
	
	@Column(name = "STATUS")
	private String status;
	
	
	/**
	 * 
	 */
	public UserProfileVO() {
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
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
