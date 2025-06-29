package com.ciu.db2.tp3.vuelos.config;

import java.time.Duration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.ciu.db2.tp3.vuelos.model.Aeropuerto;



@Configuration
public class EhCacheConfig {

	  @Bean("ehCacheManager")
	  public CacheManager EhcacheManager() {
	    CacheConfiguration<Long, Aeropuerto> cacheConfiguration = 
	    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,
	    		Aeropuerto.class, 
	        ResourcePoolsBuilder
	          .newResourcePoolsBuilder()
	          .offheap(10, MemoryUnit.MB)
	          .build())
	        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(60)))
	        .build();
	    
	    CachingProvider provider = Caching.getCachingProvider();  
	    CacheManager cacheManager = provider.getCacheManager(); 

	    javax.cache.configuration.Configuration<Long, Aeropuerto> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfiguration);
	    cacheManager.createCache("aeropuertoStore", configuration);
	    return cacheManager;
	  }  
}
