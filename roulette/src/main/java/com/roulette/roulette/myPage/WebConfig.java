package com.roulette.roulette.myPage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)   // 인터셉터 우선순위
                .addPathPatterns("/**")   //("/**") -> 모든 경로 의미
                .excludePathPatterns("/", "/login", "/error");  //인터셉터적용하지 않는 부분

    };
}
