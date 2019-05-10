package com.rkg.apollotest;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class ApollotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApollotestApplication.class, args);
    }

}
