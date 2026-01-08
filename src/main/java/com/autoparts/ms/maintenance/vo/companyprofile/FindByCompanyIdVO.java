/**
 * 
 */
package com.autoparts.ms.maintenance.vo.companyprofile;

import java.io.Serializable;

import com.autoparts.core.validator.json.JsonDeserializeValidator;
import com.autoparts.core.validator.json.annotation.Mandatory;
import com.autoparts.core.validator.json.annotation.Number;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = JsonDeserializeValidator.class)
public class FindByCompanyIdVO implements Serializable{
	
	@Mandatory
	private String companyId;
	
	@Mandatory
	@Number(min = "1")
	private Integer page;
	
	
	/**
	 * 
	 */
	public FindByCompanyIdVO() {
		// TODO Auto-generated constructor stub
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	
	

}
