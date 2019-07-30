package com.gaozhao.app_security.config;


import com.gaozhao.app_security.properties.SecurityMainProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 属性配置生效配置
 * @author mars_lv
 */
@Configuration
@EnableConfigurationProperties(SecurityMainProperties.class)
public class SecurityPropertiesConf {
}
