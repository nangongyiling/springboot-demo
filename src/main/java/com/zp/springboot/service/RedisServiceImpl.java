package com.zp.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private KeyGenerator keyGenerator;
	
	@Override
	public Object findByKey(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public Object cacheObject(String result) {
		try {
			Object keyObject = keyGenerator.generate(this,this.getClass().getMethod("cacheObject", 
					new Class<?>[]{String.class}), "xxx");
			if(!redisTemplate.hasKey(keyObject)){
				redisTemplate.opsForValue().set("zp",result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
