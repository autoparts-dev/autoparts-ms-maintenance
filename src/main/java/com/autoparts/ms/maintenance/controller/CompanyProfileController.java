/**
 * 
 */
package com.autoparts.ms.maintenance.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.ResponseHandler;
import com.autoparts.ms.maintenance.services.CompanyProfileService;
import com.autoparts.ms.maintenance.vo.company.CompanyCreateVO;
import com.autoparts.ms.maintenance.vo.company.CompanyListVO;
import com.autoparts.ms.maintenance.vo.company.CompanyUpdateVO;


/**
 * @author sosseres
 * 
 */
@RestController 
@RequestMapping("/ap/maintenance/company/v1")
public class CompanyProfileController {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileController.class.getName());
	
	@Autowired
	private CompanyProfileService companyProfileService;
	
	@Autowired
	private ResponseHandler responseHandler;

	/**
	 * 
	 */
	public CompanyProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/ping")
	public int ping() {
		return 200;
	}
	
	
	@GetMapping(path = "/findCompanyById/{id}", produces = "application/json")
	public ResponseEntity findCompanyById(@PathVariable(name = "id") String id) throws Exception {
		log.debug("call findCompanyById=" + id);
		
		return responseHandler.ok(companyProfileService.findCompanyById(id));
	}
	
	@PostMapping(path = "/findCompanyByName", produces = "application/json", consumes = "application/json")
	public ResponseEntity findCompanyByName(@RequestBody CompanyListVO vo) throws Exception {
		log.debug("call findCompanyByName= {}, {}", vo.getName(), vo.getPage());
		
		return responseHandler.ok(
				companyProfileService.findCompanyByName(
						vo.getName(), vo.getPage()));
		
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity create(@RequestBody CompanyCreateVO vo) throws Exception {
		
		String id = companyProfileService.createCompany(vo);
		
		return responseHandler.ok(
				new HashMap<>() {{put("id", id);}}
		);
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity update(@RequestBody CompanyUpdateVO vo) throws Exception {
		
		companyProfileService.updateCompany(vo);
		
		return responseHandler.ok();
	}
	
	@PostMapping(path = "/delete/{id}", produces = "application/json")
	public ResponseEntity delete(@PathVariable(name = "id") String id) throws Exception{

		companyProfileService.deleteCompany(id);
		
		return responseHandler.ok();	
	}
	
	@PostMapping(path = "/remove/{id}", produces = "application/json")
	public ResponseEntity remove(@PathVariable(name = "id") String id) throws Exception{
		companyProfileService.removeCompany(id);
		
		return responseHandler.ok();	
	}
	
	

}
