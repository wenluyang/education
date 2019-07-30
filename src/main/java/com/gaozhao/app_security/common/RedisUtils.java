package com.gaozhao.app_security.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis操作
 * @author mars_lv
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * key的过期时间，默认是三分钟
     */
    private final long expireTime=180;

    /**
     * 存储一个key-value值
     * @param key
     * @param value
     */
    public void Store(String key,String value){

        ValueOperations<String,String> vp  =redisTemplate.opsForValue();
        vp.set(key,value,expireTime,TimeUnit.SECONDS);

    }

    /**
     * 获取指定的key值
     * @param kye
     * @return
     */
    public String getKey(String kye){
        return redisTemplate.opsForValue().get(kye);
    }
}
