/**
 * 
 */
package com.autoparts.ms.maintenance.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.autoparts.common.FeignClientConfig;
import com.autoparts.common.web.vo.ResponseVO;


/**
 * @author sosseres
 *
 */
@FeignClient(contextId = "UserProfileClient", name = "maintenance-service", path = "/ap/maintenance/user/v1", configuration = FeignClientConfig.class)
//@FeignClient(contextId = "UserProfileClient", name = "maintenance-service", path = "/ap/maintenance/user/v1", configuration = FeignClientConfig.class, url = "localhost:8081")
public interface UserProfileClient {

	@GetMapping(path = "/findUserById/{id}")
	public ResponseEntity<ResponseVO> findUserById(@PathVariable(name = "id") String id) throws Exception ;
	
//	@PostMapping(path = "/activate/{id}")
//	public ResponseEntity activate(@PathVariable(name = "id") String id) throws Exception ;
	
//	@GetMapping("/ping")
//	public int ping();
		
	
	
}
