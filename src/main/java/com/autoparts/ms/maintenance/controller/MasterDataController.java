/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.ms.maintenance.services.MasterDataService;
import com.autoparts.ms.maintenance.vo.masterdata.StateVO;

/**
 * @author sosseres
 *
 */

@RestController 
@RequestMapping("/ap/maintenance/masterdata/v1")
public class MasterDataController {

	@Autowired
	private MasterDataService service;
	
	/**
	 * 
	 */
	public MasterDataController() {
		// TODO Auto-generated constructor stub
		
	}
	
	@GetMapping(path = "/get/states/{countryCode}", produces = "application/json")
	public ResponseEntity<List<StateVO>> getStates(@PathVariable("countryCode") String countryCode) throws Exception {
		return ResponseEntity.ok(service.getStates(countryCode));	
	}


}
