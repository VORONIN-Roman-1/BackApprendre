package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                 
         //.apis(RequestHandlerSelectors.none())
         //.apis(RequestHandlerSelectors.any()) 
         .apis(RequestHandlerSelectors.basePackage("com.example.demo.web"))  //defaultResourcesProvider
                 
          //.paths(PathSelectors.none())
         .paths(PathSelectors.any())  
          .build();                                         
    
    }
    
 // load yml configuration spec
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            SwaggerResource swaggerResourceOAS3 = new SwaggerResource();
           
            swaggerResourceOAS3.setName("Open API 3");
            swaggerResourceOAS3.setSwaggerVersion("2.0");
            //wsResource.setLocation("/swagger.json");            
            swaggerResourceOAS3.setLocation("/swagger-OAS3.yml");//you must locate swagger.yml in src/main/resources/static folder
            
//            SwaggerResource swaggerResourceSS2 = new SwaggerResource();
//            swaggerResourceSS2.setName("swagger: 2.0");
//            swaggerResourceSS2.setLocation("/swagger-2.0.yml");//you must locate swagger.yml in src/main/resources/static folder
            
            
           // List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(swaggerResourceOAS3);                         //set the swagger.yml resourcesProvider = 1st display out of the box of swaggerUI
  //          resources.add(swaggerResourceSS2);  
            resources.addAll(defaultResourcesProvider.get());  // optionaly allow to choose defaultResourcesProvider
            
            return resources;
        };
    }
}

