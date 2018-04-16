package com.sooncode.creative_build_api_doc_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration 
@ServletComponentScan
 
 
public class ApiDocService4CreativeBuild {

    public static void main(String[] args) {
        SpringApplication.run(ApiDocService4CreativeBuild.class, args);
    }
    

    
}
