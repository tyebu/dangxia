package com.wxc.dangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DangxiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangxiaApplication.class, args);
    }

}
