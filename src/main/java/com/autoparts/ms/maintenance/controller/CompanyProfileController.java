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

import com.autoparts.common.controller.FrontController;
import com.autoparts.ms.maintenance.service.CompanyProfileService;
import com.autoparts.ms.maintenance.vo.company.CompanyCreateVO;
import com.autoparts.ms.maintenance.vo.company.CompanyListVO;
import com.autoparts.ms.maintenance.vo.company.CompanyUpdateVO;


/**
 * @author sosseres
 * 
 */
@RestController 
@RequestMapping("/ap/maintenance/company/v1")
public class CompanyProfileController extends FrontController{
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileController.class.getName());
	
	@Autowired
	private CompanyProfileService companyProfileService;

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
		
		return ok(
				companyProfileService.findCompanyById(id));
	}
	
	@PostMapping(path = "/findCompanyByName", produces = "application/json")
	public ResponseEntity findCompanyByName(@RequestBody CompanyListVO vo) throws Exception {
		log.debug("call findCompanyByName=" + vo.getName() + ", " + vo.getPage());
		
		return ok(
				companyProfileService.findCompanyByName(
						vo.getName(), vo.getPage()));
		
	}
	
	@PostMapping(path = "/createCompany", produces = "application/json")
	public ResponseEntity createCompany(@RequestBody CompanyCreateVO vo) throws Exception {
		log.debug("call createCompany. " + vo.getName());
		
		String id = companyProfileService.createCompany(vo);
		return ok(
				new HashMap<>() {{put("id", id);}}
		);
	}
	
	@PostMapping(path = "/updateCompany", produces = "application/json")
	public ResponseEntity updateCompany(@RequestBody CompanyUpdateVO vo) throws Exception {
		log.debug("call updateCompany=" + vo.getId());
		
		companyProfileService.updateCompany(vo);
		
		return ok();
	}
	
	@PostMapping(path = "/deleteCompany/{id}")
	public ResponseEntity deleteCompany(@PathVariable(name = "id") String id) throws Exception{

		companyProfileService.deleteCompany(id);
		
		return ok();	
	}
	
	@PostMapping(path = "/removeCompany/{id}")
	public ResponseEntity removeCompany(@PathVariable(name = "id") String id) throws Exception{
		companyProfileService.removeCompany(id);
		
		return ok();	
	}
	
	

}
