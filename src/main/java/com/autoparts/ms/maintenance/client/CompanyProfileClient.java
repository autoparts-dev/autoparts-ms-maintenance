/**
 * 
 */
package com.autoparts.ms.maintenance.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autoparts.common.FeignClientConfig;
import com.autoparts.ms.maintenance.vo.CompanyCreateVO;

/**
 * @author sosseres
 *
 */
@FeignClient(contextId = "CompanyProfileClient", name = "maintenance-service", path = "/ap/maintenance/company/v1", configuration = FeignClientConfig.class)
//@FeignClient(contextId = "CompanyProfileClient", name = "maintenance-service", path = "/ap/maintenance/company/v1", configuration = FeignClientConfig.class, url = "localhost:8081")
public interface CompanyProfileClient {


	@GetMapping(path = "/findCompanyById/{id}", produces = "application/json")
	public ResponseEntity<?> findCompanyById(@PathVariable(name = "id") String id) throws Exception ;
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> create(@RequestBody CompanyCreateVO vo) throws Exception;
	
	
}
