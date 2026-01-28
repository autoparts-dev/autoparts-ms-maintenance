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
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyCoordinateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileCreateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileVO;


/**
 * @author sosseres
 * 
 */
@FeignClient(contextId = "CompanyProfile", name = "maintenance-service", path = "/ap/maintenance/companyprofile/v1", configuration = FeignClientConfig.class)
//@FeignClient(contextId = "CompanyProfile", name = "maintenance-service", path = "/ap/maintenance/companyprofile/v1", configuration = FeignClientConfig.class, url = "localhost:8081")
public interface CompanyProfile{
	
	
//	@GetMapping(path = "/get/{id}", produces = "application/json")
//	public ResponseEntity<ResponseVO> findById(@PathVariable("id") String id) throws Exception;
//	
//	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
//	public ResponseEntity<ResponseVO> create(@RequestBody CompanyProfileCreateVO vo) throws Exception;
//	
//	@PostMapping(path = "/update/coordinate", produces = "application/json")
//	public ResponseEntity<ResponseVO> updateCoordinate(@RequestBody CompanyCoordinateVO vo) throws Exception;

	
	
	@GetMapping(path = "/get/{id}", produces = "application/json")
	public ResponseEntity<CompanyProfileVO> findById(@PathVariable("id") String id) throws Exception;
	
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody CompanyProfileCreateVO vo) throws Exception;
	
	@PostMapping(path = "/update/coordinate", produces = "application/json")
	public ResponseEntity updateCoordinate(@RequestBody CompanyCoordinateVO vo) throws Exception ;

}
