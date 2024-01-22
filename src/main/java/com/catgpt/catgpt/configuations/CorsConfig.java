package com.catgpt.catgpt.configuations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Đặt các thông tin cấu hình CORS
        config.setAllowCredentials(true);
        config.addAllowedOrigin("https://quanndb.github.io/CatGPT");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // Áp dụng cấu hình cho tất cả các URL
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
