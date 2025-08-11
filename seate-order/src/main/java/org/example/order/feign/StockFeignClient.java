package org.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "stock", configuration = FeignConfig.class)
public interface StockFeignClient {

    @PostMapping("/stock/reduce")
    String reduceStock(@RequestParam("productId") String productId);
}