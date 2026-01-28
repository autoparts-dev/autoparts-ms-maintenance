/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.autoparts.ms.maintenance.services.CompanyProfileCache;
import com.autoparts.ms.maintenance.services.CompanyProfileService;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyCoordinateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileCreateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileVO;


/**
 * @author sosseres
 * 
 */
@RestController 
@RequestMapping("/ap/maintenance/companyprofile/v1")
public class CompanyProfileController {
	
	@Autowired
	private CompanyProfileService service;
	
//	@Autowired
//	private CompanyProfileCache companyProfileCache;
	
	/*
	 * 
	 */
	public CompanyProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<CompanyProfileVO> findById(@PathVariable("id") String id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody CompanyProfileCreateVO vo) throws Exception{
		return ResponseEntity.ok(service.create(vo));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity update(@RequestBody CompanyProfileUpdateVO vo) throws Exception {
		service.update(vo);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(path = "/update/coordinate", produces = "application/json")
	public ResponseEntity updateCoordinate(@RequestBody CompanyCoordinateVO vo) throws Exception {
		service.updateCoordinate(vo);
		return ResponseEntity.ok().build(); 
	}


}
