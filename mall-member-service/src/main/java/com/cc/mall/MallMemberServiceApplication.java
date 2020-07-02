package com.cc.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.cc.mall.mapper")
public class MallMemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberServiceApplication.class, args);
    }

}
