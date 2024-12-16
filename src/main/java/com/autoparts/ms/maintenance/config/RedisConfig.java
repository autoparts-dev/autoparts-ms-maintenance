/**
 * 
 */
package com.autoparts.ms.maintenance.config;

//import java.nio.charset.Charset;
import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author sosseres
 *
 */
@Configuration
@EnableCaching
public class RedisConfig {
	

//	public static final String TEST_ENTRY = "stages";

	/**
	 * 
	 */
	public RedisConfig() {
		// TODO Auto-generated constructor stub
	}
	
//	@Bean
//	public CacheManager cacheManager(RedisConnectionFactory factory) {
//		RedisCacheConfiguration cfg = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofSeconds(8000));
//		
//		return RedisCacheManager.builder(factory)
//				.cacheDefaults(cfg)
//				.build();
//	}
	
//	@Bean
//	public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
//		RedisTemplate tmpl = new RedisTemplate<>();
//		tmpl.setConnectionFactory(factory);
//		
//		tmpl.setKeySerializer(new StringRedisSerializer());
//		tmpl.setValueSerializer(new StringRedisSerializer());
//		
//		return tmpl;
//	}
	
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {

		RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
//				.withCacheConfiguration(RedisConfig.TEST_ENTRY, RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMillis(10000)))
				.withCacheConfiguration("companyProfileRollbackEntry", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMillis(30000)))
				.build()
				;
		
		return cacheManager;
	}
	

}
