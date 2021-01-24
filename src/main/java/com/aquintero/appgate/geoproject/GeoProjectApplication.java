package com.aquintero.appgate.geoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.aquintero.appgate.geoproject.repository")
public class GeoProjectApplication
{

    public static void main(final String []args) {
        SpringApplication.run(GeoProjectApplication.class);
    }

}
