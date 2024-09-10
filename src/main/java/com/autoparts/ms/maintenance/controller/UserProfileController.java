package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.web.ResponseHandler;
import com.autoparts.ms.maintenance.services.UserProfileService;
import com.autoparts.ms.maintenance.vo.user.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileUpdateVO;

@RestController 
@RequestMapping("/ap/maintenance/user/v1")
public class UserProfileController{
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ResponseHandler responseHandler;

	public UserProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/ping", produces = "application/json")
	public ResponseEntity ping() throws Exception {
		return responseHandler.ok();
		
	}
	
	@GetMapping(path = "/findUserById/{id}", produces = "application/json")
	public ResponseEntity findUserById(@PathVariable(name = "id") String id) throws Exception {
		return responseHandler.ok(userProfileService.findUserById(id));
	}
	
	@PostMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity update(@RequestBody UserProfileUpdateVO vo) throws Exception {
		userProfileService.updateUser(vo);
		
		return responseHandler.ok();
	}

	@PostMapping(path = "/findAllUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity findAllUser(@RequestBody UserProfileListVO vo) throws Exception {
		return responseHandler.ok(userProfileService.findAllUser(vo.getCompanyId(), vo.getPage()));
	}
	
	
	@PostMapping(path = "/delete/{id}", produces = "application/json")
	public ResponseEntity delete(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deleteUser(id);
		
		return responseHandler.ok();
	}
	
	@PostMapping(path = "/activate/{id}", produces = "application/json")
	public ResponseEntity activate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.activate(id);
		return responseHandler.ok();
	}
	
	@PostMapping(path = "/deactivate/{id}", produces = "application/json")
	public ResponseEntity deactivate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deactivate(id);
		
		return responseHandler.ok();
	}
}
