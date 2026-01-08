/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sosseres
 *
 */
@Service
public class CompanyProfileCache {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileCache.class.getName());

	private static final String CACHE_NAMES = "companyNameCahce";
//	private static final String COMPANY_ID_HASH_KEY = "company:id";
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 
	 */
	public CompanyProfileCache() {
		// TODO Auto-generated constructor stub
	}

	public boolean addCompanyName(String name) {
		return stringRedisTemplate.opsForZSet().add(CACHE_NAMES, name.toUpperCase(), 0);
//		stringRedisTemplate.opsForHash().put(COMPANY_ID_HASH_KEY, name, id);
	}
	
	public Set<String> searchByCompanyName(String name, int limit) {
		log.debug("search by {}", name);
		
		name = name.toUpperCase();
		
		String fr = ("*".equals(name) ? "" : name);
		String to = ("*".equals(name) ? "" : name) + "{";
		
		long l1 = System.currentTimeMillis();
		Set<String> lst = stringRedisTemplate.opsForZSet().rangeByLex(CACHE_NAMES, Range.range().gte(fr).lte(to));
		long l2 = System.currentTimeMillis();
		
		log.debug("total search from cache {}: {}, {}, {}ms", CACHE_NAMES, lst.size(), stringRedisTemplate.opsForZSet().size(CACHE_NAMES), (l2 - l1));
		
		return lst;
	}
	
	public boolean modifyCompanyName(String oldName, String newName) {
		long r = stringRedisTemplate.opsForZSet().remove(CACHE_NAMES, oldName);
		
		log.debug("total cache removed {}", r);
		
		return this.addCompanyName(newName);
	}
	
	
	
}
