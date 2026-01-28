package com.autoparts.ms.maintenance.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autoparts.common.web.FeignClientConfig;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileCreateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileVO;


@FeignClient(contextId = "UserProfile", name = "maintenance-service", path = "/ap/maintenance/userprofile/v1", configuration = FeignClientConfig.class)
//@FeignClient(contextId = "UserProfile", name = "maintenance-service", path = "/ap/maintenance/userprofile/v1", configuration = FeignClientConfig.class, url = "localhost:8081")
public interface UserProfile {
		
		
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody UserProfileCreateVO vo) throws Exception ;

	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<UserProfileVO> findById(@PathVariable(name = "id") String id) throws Exception;
	
	
	
}
