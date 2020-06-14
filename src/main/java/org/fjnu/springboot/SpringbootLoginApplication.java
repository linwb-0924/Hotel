package org.fjnu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("org.fjnu.springboot.mapper")
@SpringBootApplication
@EnableCaching
@EnableRabbit
public class SpringbootLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginApplication.class, args);
    }

}
