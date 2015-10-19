package com.montana.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alexto on 10/10/15.
 */
public class Mvc extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry
                .addResourceHandler("/partials/**")
                .addResourceLocations("/partials/");

        //TODO: Protect user uploads
        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations("/uploads/");
    }

    @Bean
    public MultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }


}
