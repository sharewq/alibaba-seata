package org.example.stock;

/**
 * Hello world!
 */

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.example.*.feign")
@MapperScan("org.example.stock")
@EnableAutoDataSourceProxy
public class StockApp {
    public static void main(String[] args) {
        SpringApplication.run(StockApp.class, args);
    }
}
