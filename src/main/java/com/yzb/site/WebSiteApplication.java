package com.yzb.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = "com.yzb.site.dao")
@SpringBootApplication
public class WebSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSiteApplication.class, args);
    }

}
