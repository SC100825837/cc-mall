package com.cc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cc.mall.mapper")
public class MallManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallManagerServiceApplication.class, args);
    }

}
