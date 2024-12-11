/**
 * 
 */
package com.autoparts.ms.maintenance.constants;

import com.autoparts.common.web.constants.ResponseReason;

/**
 * @author sosseres
 *
 */
public class CompanyProfileResponseReason extends ResponseReason{

	/**
	 * 
	 */
	public CompanyProfileResponseReason() {
		// TODO Auto-generated constructor stub
	}

	public static final String COMPANY_NOT_FOUND = "company_not_found";
	public static final String DUPLICATE_BRN = "duplicate_brn";
	public static final String COMPANY_DUPLICATE_ERROR = "company_duplicate_error";
}
