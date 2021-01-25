package com.aquintero.appgate.geoproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@ComponentScan(basePackages = {"com.aquintero.appgate.geoproject.converter", "com.aquintero.appgate.geoproject.services",
        "com.aquintero.appgate.geoproject.controller", "com.aquintero.appgate.geoproject.components"})
public class Config
{

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DefaultConversionService conversionService() {
        return new DefaultConversionService();
    }
}
