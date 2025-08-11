package org.example.stock.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public SeataFeignInterceptor globalTransactionFeignInterceptor() {
        return new SeataFeignInterceptor();
    }
}