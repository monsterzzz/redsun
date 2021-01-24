package com.monster.redsun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.monster.redsun.mapper")
public class RedsunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedsunApplication.class, args);
    }

}
