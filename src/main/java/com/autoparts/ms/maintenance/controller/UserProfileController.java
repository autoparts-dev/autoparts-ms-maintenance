package com.autoparts.ms.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.ms.maintenance.services.UserProfileService;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileCreateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileVO;

@RestController 
@RequestMapping("/ap/maintenance/userprofile/v1")
public class UserProfileController{
	
	@Autowired
	private UserProfileService service;
	

	public UserProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody UserProfileCreateVO vo) throws Exception {
		return ResponseEntity.ok(service.create(vo));
	}

	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<UserProfileVO> findById(@PathVariable(name = "id") String id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity update(@RequestBody UserProfileUpdateVO vo) throws Exception {
		service.update(vo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/get/all", produces = "application/json")
	public ResponseEntity<List<UserProfileListVO>> findAll(
			@RequestParam(name = "companyId") String companyId,
			@RequestParam(name = "page") int page,
			@RequestParam(name = "pageSize") int pageSize) throws Exception{
		return ResponseEntity.ok(service.findAllUserProfile(companyId, page, pageSize));
	}
	
}
