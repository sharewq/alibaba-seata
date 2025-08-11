package org.example.stock.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order", configuration = FeignConfig.class)
public interface OrderFeignClient {

    @PostMapping("/order/reduce")
    String reduceOrder(@RequestParam("productId") String productId);
}