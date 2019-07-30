package com.gaozhao.app_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Copyright: Copyright (c) 2019  GAOZHAO
 *
 * @ClassName: MyRedisConfig.java
 * @Description:
 * @version: v1.0.0
 * @author: YangQianLei
 * @date: 2019年 07月30日
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019年 07月30日      YangQianLei          v1.0.0             创建
 */
public class MyRedisConfig {
    /**
     * 自定义redis序列化
     * @param  * @param redisConnectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.Object,java.lang.Object>
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();

        template.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        template.setDefaultSerializer(serializer);
        return template;
    }

}
