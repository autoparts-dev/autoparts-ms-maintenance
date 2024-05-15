/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.FrontController;

/**
 * @author sosseres
 *
 */
@RestController
@RequestMapping("/ap/maintenance/config/v1")
public class ConfigController extends FrontController{

	/**
	 * 
	 */
	public ConfigController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping()
	public ResponseEntity encrypt() {
		
		return null;
	}
	
	

}
