/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Integrating Swagger 2 into the Project
 * The configuration of Swagger mainly centers around the Docket bean.
 * @author Chukwudi Ugorji
 */
@Configuration //
@EnableSwagger2 //Swagger 2 is enabled through the @EnableSwagger2 annotation of io.springfox version 2.9.2.
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        /*
        After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder, 
        which provides a way to control the endpoints exposed by Swagger.
        Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and PathSelectors. 
        Using any() for both will make documentation for your entire API available through Swagger.
        This configuration is enough to integrate Swagger 2 into an existing Spring Boot project.
        
        http://localhost:8080/v2/api-docs to check if swagger is working
        http://localhost:8080/swagger-ui.html to check if swagger ui is working
        */
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build(); 
    }
}
