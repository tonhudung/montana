package com.montana.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

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

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof AbstractJackson2HttpMessageConverter) {
                AbstractJackson2HttpMessageConverter c = (AbstractJackson2HttpMessageConverter) converter;
                ObjectMapper objectMapper = c.getObjectMapper();
                objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            }
        }

        super.extendMessageConverters(converters);
    }

    @Bean
    public MultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }

}
