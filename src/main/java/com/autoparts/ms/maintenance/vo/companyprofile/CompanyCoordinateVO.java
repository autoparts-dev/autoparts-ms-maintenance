/**
 * 
 */
package com.autoparts.ms.maintenance.vo.companyprofile;

import java.io.Serializable;

import com.autoparts.core.validator.json.JsonDeserializeValidator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author sosseres
 *
 */
@JsonDeserialize(using = JsonDeserializeValidator.class)
public class CompanyCoordinateVO implements Serializable{

	private String id;
	private double latitude;
	private double longitude;
	
	/**
	 * 
	 */
	public CompanyCoordinateVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
