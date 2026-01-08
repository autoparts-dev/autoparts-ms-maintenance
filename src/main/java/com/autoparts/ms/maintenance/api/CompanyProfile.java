/**
 * 
 */
package com.autoparts.ms.maintenance.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autoparts.common.web.FeignClientConfig;
import com.autoparts.common.web.vo.ResponseVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileCreateVO;


/**
 * @author sosseres
 * 
 */
@FeignClient(contextId = "CompanyProfile", name = "maintenance-service", path = "/ap/maintenance/companyprofile/v1", configuration = FeignClientConfig.class)
//@FeignClient(contextId = "CompanyProfile", name = "maintenance-service", path = "/ap/maintenance/companyprofile/v1", configuration = FeignClientConfig.class, url = "localhost:8081")
public interface CompanyProfile{
	
	
	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<ResponseVO> findById(@PathVariable("id") String id) throws Exception;
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ResponseVO> create(@RequestBody CompanyProfileCreateVO vo) throws Exception;
	

	

}
