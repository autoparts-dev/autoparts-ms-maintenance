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

import com.autoparts.common.web.controller.ResponseController;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.services.CompanyProfileService;
import com.autoparts.ms.maintenance.vo.CompanyCreateVO;
import com.autoparts.ms.maintenance.vo.CompanyUpdateVO;
import com.autoparts.ms.maintenance.vo.FindByCompanyNameVO;


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
	private ResponseController responseController;

	/**
	 * 
	 */
	public CompanyProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/ping", produces = "application/json")
	public ResponseEntity<ResponseVO> ping() throws Exception {
		return responseController.ok();
		
	}
	
	
	@GetMapping(path = "/findCompanyById/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> findCompanyById(@PathVariable(name = "id") String id) throws Exception {
		log.debug("call findCompanyById=" + id);
		
		return responseController.ok(companyProfileService.findCompanyById(id));
	}
	
	@PostMapping(path = "/findCompanyByName", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> findCompanyByName(@RequestBody FindByCompanyNameVO vo) throws Exception {
		log.debug("call findCompanyByName= {}, {}", vo.getName(), vo.getPage());
		
		return responseController.ok(
				companyProfileService.findCompanyByName(
						vo.getName(), vo.getPage()));
		
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> create(@RequestBody CompanyCreateVO vo) throws Exception {
		log.debug("create new company.");
		
		String id = companyProfileService.createCompany(vo);
		
		return responseController.ok(
				new HashMap<>() {{put("id", id);}}
		);
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> update(@RequestBody CompanyUpdateVO vo) throws Exception {
		
		companyProfileService.updateCompany(vo);
		
		return responseController.ok();
	}
	
	@PostMapping(path = "/delete/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> delete(@PathVariable(name = "id") String id) throws Exception{

		companyProfileService.deleteCompany(id);
		
		return responseController.ok();	
	}
	
	@PostMapping(path = "/remove/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> remove(@PathVariable(name = "id") String id) throws Exception{
		companyProfileService.removeCompany(id);
		
		return responseController.ok();	
	}
	
	

}
