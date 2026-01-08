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

import com.autoparts.common.web.AbstractCommonController;
import com.autoparts.common.web.vo.ResponseVO;
//import com.autoparts.ms.maintenance.services.CompanyProfileCache;
import com.autoparts.ms.maintenance.services.CompanyProfileService;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileCreateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileUpdateVO;


/**
 * @author sosseres
 * 
 */
@RestController 
@RequestMapping("/ap/maintenance/companyprofile/v1")
public class CompanyProfileController extends AbstractCommonController {
	
	@Autowired
	private CompanyProfileService companyProfileService;
	
//	@Autowired
//	private CompanyProfileCache companyProfileCache;
	
	/*
	 * 
	 */
	public CompanyProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> findById(@PathVariable("id") String id) throws Exception{
		return ok(companyProfileService.findById(id));
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> create(@RequestBody CompanyProfileCreateVO vo) throws Exception{
		return ok(companyProfileService.create(vo));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> update(@RequestBody CompanyProfileUpdateVO vo) throws Exception {
		companyProfileService.update(vo);
		return ok();
	}


}
