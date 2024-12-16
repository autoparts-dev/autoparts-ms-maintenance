/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.autoparts.ms.maintenance.vo.RollbackVO;

/**
 * @author sosseres
 *
 */
@Service
public class CompanyProfileRollbackService {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileRollbackService.class.getName());

	/**
	 * 
	 */
	public CompanyProfileRollbackService() {
		// TODO Auto-generated constructor stub
	}
	
	@Cacheable(cacheNames = "companyProfileRollbackEntry", key = "#cacheId")
	public RollbackVO get(String cacheId) {
		log.info("get from companyProfileRollback cache with {}", cacheId);
		return null;
	}
	
	@CachePut(cacheNames = "companyProfileRollbackEntry", key = "#cacheId")
	public RollbackVO set(String cacheId, RollbackVO vo) {
		log.info("set into companyProfileRollbackEntry cache with {}", cacheId);
		return vo;
		
	}
	
	@CacheEvict(cacheNames = "companyProfileRollbackEntry", key = "#cacheId")
	public void remove(String cacheId) {
		log.info("remove cacheId: {} from companyProfileRollbackEntry cache", cacheId);
	}
	
	

}
