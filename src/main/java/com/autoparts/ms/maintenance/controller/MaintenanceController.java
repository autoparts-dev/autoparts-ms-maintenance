/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.ApplicationParameter;
import com.autoparts.common.web.ResponseHandler;
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
	private ResponseHandler responseHandler;
	
	@Autowired
	private ApplicationParameter applicationParameter;
	
	/**
	 * 
	 */
	public MaintenanceController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/ping", produces = "application/json")
	public ResponseEntity ping() throws Exception {
		return responseHandler.ok();
		
	}
	
	@GetMapping(path = "/getListOfProductCategory", produces = "application/json")
	public ResponseEntity getListOfProductCategory() throws Exception{
		
		System.out.println("->" + applicationParameter.packageToScan);
		
		return responseHandler.ok(maintenanceService.getListOfProductCategory());
		
	}

}
