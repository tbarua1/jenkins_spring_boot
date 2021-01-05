package com.h2.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessagingControllerFromPropertiesFile {
    @Value("${spring.jpa.database-platform}")   // coming from templating engine
    private String platform;
    @Value("${spring.datasource.url}")
    private String dburl;


    @RequestMapping("/msg")
    public Map<String,String> sayGreeting(){
//        List<String> completeInformation=new ArrayList<>();
        Map<String,String> completeInformation=new HashMap<>();
        completeInformation.put("url",dburl);
        completeInformation.put("platform",platform);
        return completeInformation;
    }
}
