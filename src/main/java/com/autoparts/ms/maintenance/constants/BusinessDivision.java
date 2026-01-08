/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

/**
 * @author sosseres
 *
 */
public enum BusinessDivision {

    TYRES("TY"),
    CAR_PARTS("PT"),
    CONSUMABLE_PARTS("CP"),
    HEAVY_PARTS("HP")
    ;

	/**
	 * 
	 */
	private String value;
	
	private BusinessDivision(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
