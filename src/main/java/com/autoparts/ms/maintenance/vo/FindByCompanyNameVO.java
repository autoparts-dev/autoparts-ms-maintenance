/**
 * 
 */
package com.autoparts.ms.maintenance.vo;

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
public class FindByCompanyNameVO implements Serializable {

	@Mandatory
	private String name;
	
	@Mandatory
	@Number(min = "1")
	private Integer page;
	
	
	

	
	/**
	 * 
	 */
	public FindByCompanyNameVO() {
		// TODO Auto-generated constructor stub
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public Integer getPage() {
		return page;
	}





	public void setPage(Integer page) {
		this.page = page;
	}



}
