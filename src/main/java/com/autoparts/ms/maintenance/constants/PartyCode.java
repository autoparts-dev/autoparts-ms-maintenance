/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

/**
 * @author sosseres
 *
 */
public enum PartyCode {

    TYRE_WORKSHOP("TYRE_WORKSHOP"),
    REPAIR_WORKSHOP("REPAIR_WORKSHOP"),
    TYRE_SUPPLIER("TYRE_SUPPLIER"),
    PARTS_SUPPLIER("PARTS_SUPPLIER"),
    
//    CAR_PARTS("PT"),
//    CONSUMABLE_PARTS("CP"),
//    HEAVY_PARTS("HP")
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

}
