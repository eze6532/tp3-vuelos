package com.ciu.db2.tp3.vuelos.config;

import java.time.Duration;
import java.util.UUID;

import javax.cache.CacheManager;
import javax.cache.Caching;
import org.ehcache.event.EventType;

import javax.cache.spi.CachingProvider;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.ciu.db2.tp3.vuelos.model.Aeropuerto;




@Configuration
@EnableCaching
public class EhCacheConfig {

	@Bean("ehCacheManager")
	public JCacheCacheManager EhcacheManager() {
	    CacheEventListenerConfigurationBuilder eventLoggerConfig =
	        CacheEventListenerConfigurationBuilder
	            .newEventListenerConfiguration(
	                new AeropuertoCacheEventLogger(), 
	                EventType.CREATED, EventType.UPDATED, EventType.EXPIRED, EventType.EVICTED, EventType.REMOVED
	            )
	            .unordered().asynchronous();

	    CacheConfiguration<UUID, Aeropuerto> cacheConfiguration =
	        CacheConfigurationBuilder.newCacheConfigurationBuilder(
	                UUID.class,
	                Aeropuerto.class,
	                ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(10, MemoryUnit.MB)
	        )
	        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(360)))
	        .withService(eventLoggerConfig.build()) 
	        .build();

	    CachingProvider provider = Caching.getCachingProvider();
	    CacheManager cacheManager = provider.getCacheManager();

	    javax.cache.configuration.Configuration<UUID, Aeropuerto> configuration =
	        Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfiguration);

	    cacheManager.createCache("aeropuertoStore", configuration);

	    return new JCacheCacheManager(cacheManager);
	}


}
