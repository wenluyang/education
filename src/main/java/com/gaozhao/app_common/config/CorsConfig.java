package com.gaozhao.app_common.config;


import com.gaozhao.app_security.properties.SecurityMainProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**   
 * @ClassName: CorsConfig.java
 * @Description: 解决跨域问题
 *
  */
@Configuration
public class CorsConfig {

    @Autowired
    private SecurityMainProperties mainProperties;


	private CorsConfiguration buildConfig() {
	    String tokenName=mainProperties.getCommon().getAuthTokenName();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //允许任何域名
        String[] headers=new String[]{"*"};
        corsConfiguration.setAllowedHeaders(Arrays.asList(headers));//允许任何有效头信息
        corsConfiguration.addAllowedMethod("*");//允许所有的有效请求方法
        corsConfiguration.addExposedHeader(tokenName);
        return corsConfiguration;
    }

    //在没有springSecurity环境下使用下面的配置
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }c

    //有springSecurity环境,我们在springSecurity下配置需要这个实现才能完成跨域配置
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return source;
    }
}
