package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.utils.ResponseUtils;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.services.UserProfileService;
import com.autoparts.ms.maintenance.vo.FindByCompanyIdVO;
import com.autoparts.ms.maintenance.vo.UserProfileUpdateVO;

@RestController 
@RequestMapping("/ap/maintenance/user/v1")
public class UserProfileController{
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ResponseUtils responseUtils;

	public UserProfileController() {
		// TODO Auto-generated constructor stub
	}
	
//	@GetMapping(path = "/ping", produces = "application/json")
//	public ResponseEntity<ResponseVO> ping() throws Exception {
//		return responseUtils.ok();
//		
//	}
	
	@GetMapping(path = "/findUserById/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> findUserById(@PathVariable(name = "id") String id) throws Exception {
		return responseUtils.ok(userProfileService.findUserById(id));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> update(@RequestBody UserProfileUpdateVO vo) throws Exception {
		userProfileService.updateUser(vo);
		
		return responseUtils.ok();
	}

	@PostMapping(path = "/findAllUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> findAllUser(@RequestBody FindByCompanyIdVO vo) throws Exception {
		return responseUtils.ok(userProfileService.findAllUser(vo.getCompanyId(), vo.getPage()));
	}
	
	
	@PostMapping(path = "/delete/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> delete(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deleteUser(id);
		
		return responseUtils.ok();
	}
	
	@PostMapping(path = "/activate/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> activate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.activate(id);
		return responseUtils.ok();
	}
	
	@PostMapping(path = "/deactivate/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> deactivate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deactivate(id);
		
		return responseUtils.ok();
	}
}
