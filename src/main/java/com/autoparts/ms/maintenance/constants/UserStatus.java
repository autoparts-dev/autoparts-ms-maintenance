/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

/**
 * @author sosseres
 *
 */
public enum UserStatus {

	PASSWORD_RESET_REQUIRE("PWRQ"),
//	PENDING_VERIFICATION("PVERI"),
//	PENDING_ACTIVATE("PACTV"),
	ACTIVE("ACTV"),
	DEACTIVATE("DACTV"),
	LOCKED("LOCKED"),
	DELETED("DEL"),
	;
	
	private String value;
	
	private UserStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
//	PACTV -> ACTV -> D / L / RSTREQ

	
	
}
 