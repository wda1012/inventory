package com.chemical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class,args);
    }
}
