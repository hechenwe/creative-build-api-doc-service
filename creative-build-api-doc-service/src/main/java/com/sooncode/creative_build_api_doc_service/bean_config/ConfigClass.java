package com.sooncode.creative_build_api_doc_service.bean_config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:bean_manager/spring-comm-dao.xml"})
public class ConfigClass {
    
}