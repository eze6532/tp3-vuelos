package com.ciu.db2.tp3.vuelos.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class AeropuertoCacheEventLogger implements CacheEventListener<Object, Object>{

	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> event) {
		System.out.println(" EhCache EVENTO: " + event.getType()
        + " | key: " + event.getKey()
        + " | oldValue: " + event.getOldValue()
        + " | newValue: " + event.getNewValue());
	}
}
