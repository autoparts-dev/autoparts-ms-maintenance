/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

/**
 * @author sosseres
 *
 */
public enum CompanyStatus {
	
	ACTIVE("ACTV")
	;

	/**
	 * 
	 */
	private String value;
	
	private CompanyStatus(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
//	public static final String ACTIVE = "ACTV";
//
//	public static final String PENDING_ACTIVATE = "PACTV";

}
