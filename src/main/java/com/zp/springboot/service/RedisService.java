package com.zp.springboot.service;

public interface RedisService {

	Object findByKey(String key);
	
	Object cacheObject(String result);
}
