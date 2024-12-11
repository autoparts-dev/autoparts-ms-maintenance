/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.utils.ResponseUtils;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.services.MaintenanceService;

/**
 * @author sosseres
 *
 */
@RestController
@RequestMapping("/ap/maintenance/service/v1")
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;
	
	@Autowired
	private ResponseUtils responseUtils;
	
	/**
	 * 
	 */
	public MaintenanceController() {
		// TODO Auto-generated constructor stub
	}
	
//	@GetMapping(path = "/ping", produces = "application/json")
//	public ResponseEntity ping() throws Exception {
//		return responseHandler.ok();
//		
//	}
	
	@GetMapping(path = "/getProductCategory", produces = "application/json")
	public ResponseEntity<ResponseVO> getProductCategory() throws Exception{
		
		
		return responseUtils.ok(maintenanceService.getProductCategory());
		
	}

}
