/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.autoparts.core.entity.Action;
import com.autoparts.ms.maintenance.vo.RollbackVO;

/**
 * @author sosseres
 *
 */
@Service
@Deprecated
public class CacheService {
	
//	@Autowired
//	private RedisTemplate redisTemplate;
	
//	@Autowired
//	private CacheManager cacheManager;

	/**
	 * 
	 */
	public CacheService() {
		// TODO Auto-generated constructor stub
	}
	
	@Cacheable(cacheNames = "stages", key = "#cacheId")
	public String get(String cacheId) {
		return null;
	}
	
	@CachePut(cacheNames = "stages", key = "#cacheId")
	public String set(String cacheId, String val) {
//		String key = "stages::" + id;
//		redisTemplate.expire(key, Duration.ofMillis(8000));
//		redisTemplate.opsForValue().set(key, val);
		
//		RollbackVO vo = new RollbackVO(cacheId, Action.INSERT, "T_COMPANY", val);
		
		return val;
		
	}
	
//	public String getPreviousStage(String id) {
//		
//		System.out.println("-->" + redisTemplate.getExpire("stages::" + id));
//		
//		String s = (String) redisTemplate.opsForValue().get("stages::" + id);
//		System.out.println("--> " + s);
//		return s;
//	}
	
	

}
