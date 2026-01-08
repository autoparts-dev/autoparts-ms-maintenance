/**
 * 
 */
package com.autoparts.ms.maintenance.vo.userprofile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.autoparts.core.entity.mysql.PageObject;

/**
 * @author sosseres
 *
 */
@Entity
public class UserProfileListVO extends PageObject implements Serializable{

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MOBILE_NUM")
	private String mobileNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COMPANY_ID")
	private String companyId;
	
	@Column(name = "STATUS_ID")
	private String statusId;
	
	
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
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	

}
