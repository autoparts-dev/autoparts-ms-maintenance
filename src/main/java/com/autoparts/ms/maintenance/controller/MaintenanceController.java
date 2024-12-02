/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.controller.ResponseController;
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
	private ResponseController responseController;
	
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
	
	@GetMapping(path = "/getListOfProductCategory", produces = "application/json")
	public ResponseEntity<ResponseVO> getListOfProductCategory() throws Exception{
		
		
		return responseController.ok(maintenanceService.getListOfProductCategory());
		
	}

}
