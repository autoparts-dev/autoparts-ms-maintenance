/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.AbstractCommonController;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.services.MasterDataService;

/**
 * @author sosseres
 *
 */

@RestController 
@RequestMapping("/ap/maintenance/masterdata/v1")
public class MasterDataController extends AbstractCommonController {

	@Autowired
	private MasterDataService masterDataService;
	
	/**
	 * 
	 */
	public MasterDataController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/states/get/{countryCode}", produces = "application/json")
	public ResponseEntity<ResponseVO> getStates(@PathVariable("countryCode") String countryCode) throws Exception {
		return ok(masterDataService.getStates(countryCode));
		
	}


}
