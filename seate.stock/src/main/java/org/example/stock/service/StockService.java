package org.example.stock.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.stock.dto.Stock;
import org.example.stock.feign.OrderFeignClient;
import org.example.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StockService {

    @Resource
    private StockMapper stockMapper;

    @Resource
    private OrderFeignClient orderFeignClient;

    @Transactional(rollbackFor = Exception.class)
    public boolean reduceStock(String productId) {
        System.out.println("扣减库存开始,productId:" + productId);
        int result = stockMapper.reduceStock(productId);
        // 模拟异常
//        productId.substring(10, 2);
        System.out.println("扣减库存结束,result:" + result);
        return true;
    }


    @GlobalTransactional(name = "create-stock", rollbackFor = Exception.class)
    public boolean save() {
        System.out.println("库存,save");
        String productId = "1002";
        Stock stock = new Stock();
        stock.setProductId(productId);
        stock.setTotal(100);
        stock.setUsed(0);
        stock.setResidue(100);
        int result = stockMapper.insert(stock);
        System.out.println("insert:" + result);
        String feignResult = orderFeignClient.reduceOrder(productId);
        System.out.println("reduce order:" + feignResult);
        // 模拟异常
        productId.substring(10, 2);
        System.out.println("订单结束,result:" + result);
        return true;
    }
}
