package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.AbstractCommonController;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.services.UserProfileService;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileCreateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileUpdateVO;

@RestController 
@RequestMapping("/ap/maintenance/userprofile/v1")
public class UserProfileController extends AbstractCommonController{
	
	@Autowired
	private UserProfileService userProfileService;
	

	public UserProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> create(@RequestBody UserProfileCreateVO vo) throws Exception {
		userProfileService.create(vo);
		return ok();
	}

	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> findById(@PathVariable(name = "id") String id) throws Exception {
		return ok(userProfileService.findById(id));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> update(@RequestBody UserProfileUpdateVO vo) throws Exception {
		userProfileService.update(vo);
		return ok();
	}
	
	@GetMapping(path = "/get/all", produces = "application/json")
	public ResponseEntity<ResponseVO> findAll(
			@RequestParam(name = "companyId") String companyId,
			@RequestParam(name = "page") int page,
			@RequestParam(name = "pageSize") int pageSize) throws Exception{
		return ok(userProfileService.findAllUserProfile(companyId, page, pageSize));
	}
	
}
