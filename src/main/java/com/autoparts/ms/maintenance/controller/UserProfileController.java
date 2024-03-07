package com.autoparts.ms.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoparts.common.controller.FrontController;
import com.autoparts.ms.maintenance.service.UserProfileService;
import com.autoparts.ms.maintenance.vo.user.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileUpdateVO;

@RestController 
@RequestMapping("/ap/maintenance/user/v1")
public class UserProfileController extends FrontController{
	
	@Autowired
	private UserProfileService userProfileService;

	public UserProfileController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/ping")
	public int ping() {
		return 200;
	}
	
	@PostMapping(path = "/updateUser", produces = "application/json")
	public ResponseEntity updateUser(@RequestBody UserProfileUpdateVO vo) throws Exception {
		
		userProfileService.updateUser(vo);
		
		return ok();
	}

	@PostMapping(path = "/findAllUser", produces = "application/json")
	public ResponseEntity findAllUser(@RequestBody UserProfileListVO vo) throws Exception {
		return ok(userProfileService.findAllUser(vo.getCompanyId(), vo.getPage()));
	}
	
	@PostMapping(path = "/findUserByFirstname", produces = "application/json")
	public ResponseEntity findUserByFirstname(@RequestBody UserProfileListVO vo) throws Exception {
		return ok(userProfileService.findUserByFirstname(vo.getFirstName(), vo.getCompanyId(), vo.getPage()));
	}
	
	@GetMapping(path = "/findUserById/{id}", produces = "application/json")
	public ResponseEntity findUserById(@PathVariable(name = "id") String id) throws Exception {
		return ok(userProfileService.findUserById(id));
	}
	
	@PostMapping(path = "/deleteUser/{id}", produces = "application/json")
	public ResponseEntity deleteUser(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deleteUser(id);
		
		return ok();
	}
	
	@PostMapping(path = "/activate/{id}", produces = "application/json")
	public ResponseEntity activate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.activate(id);
		return ok();
	}
	
	@PostMapping(path = "/deactivate/{id}", produces = "application/json")
	public ResponseEntity deactivate(@PathVariable(name = "id") String id) throws Exception {
		userProfileService.deactivate(id);
		
		return ok();
	}
}
