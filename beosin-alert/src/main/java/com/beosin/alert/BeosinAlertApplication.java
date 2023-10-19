package com.beosin.alert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beosin.alert.mapper")
public class BeosinAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeosinAlertApplication.class, args);
    }

}
