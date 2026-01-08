/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

/**
 * @author sosseres
 *
 */
public enum PartyCode {

	
    WORKSHOP("Workshop"),
    SUPPLIER("Supplier")
    ;

	/**
	 * 
	 */
	private String value;
	
	private PartyCode(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
//	public static final String WORKSHOP = "Workshop";
//	public static final String SELLER = "Seller";

}
