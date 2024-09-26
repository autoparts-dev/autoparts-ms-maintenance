/**
 * 
 */
package com.autoparts.ms.maintenance.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author sosseres
 *
 */
@Entity
public class ProductCategoryVO implements Serializable{

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CD")
	private String code;
	
	@Column(name = "IMG_PATH")
	private String imagePath;
	
	
	/**
	 * 
	 */
	public ProductCategoryVO() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

}
