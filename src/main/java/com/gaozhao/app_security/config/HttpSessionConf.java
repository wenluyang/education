package com.gaozhao.app_security.config;


import com.gaozhao.app_security.properties.SecurityMainProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;


import javax.annotation.PostConstruct;

/**
 * spring-session的配置类
 * @author mars_LV
 */
@EnableRedisHttpSession
public class HttpSessionConf {

    @Autowired
    private SecurityMainProperties securityMainProperties;

//    @Autowired
//    private RedisOperationsSessionRepository redisOperationsSessionRepository;
//
//    @PostConstruct
//    private void afterPropertiesSet() {
//        redisOperationsSessionRepository.setDefaultMaxInactiveInterval(securityMainProperties.getCommon().getSessionTimeOutSecond());
//    }

    /**
     * SpringHttpSessionConfiguration默认实现使用cookie的实现，它的setter方法有个@Autowired(required = false),如果有bean实现，
     * 就使用自定义的实现,这里使用header的方式来保存springSession
     * @return
     */
    @Bean
    HttpSessionIdResolver httpSessionStrategy() {
        return new HeaderHttpSessionIdResolver("x-auth-token");
    }



//    /**
//     * 注册session的存储的仓库实现
//     * @return
//     */
//    @Bean
//    SpringSessionBackedSessionRegistry sessionRegistry(){
//        FindByIndexNameSessionRepository repository=redisOperationsSessionRepository;
//        return new SpringSessionBackedSessionRegistry(repository);
//    }
}
