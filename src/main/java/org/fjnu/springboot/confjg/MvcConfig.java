package org.fjnu.springboot.confjg;

import org.fjnu.springboot.Interceptor.LoginInterceptor;
import org.fjnu.springboot.LocalResolver.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wb_Lin
 * @create 2020-04-12 11:47
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/zhuce1").setViewName("zhuce");
        registry.addViewController("/success").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/zhuce")
        .excludePathPatterns("/user/signup").excludePathPatterns("/signup").excludePathPatterns("/user/login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
