package org.example.order.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.order.dto.Orders;
import org.example.order.feign.StockFeignClient;
import org.example.order.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private StockFeignClient stockFeignClient;

    @Resource
    public OrdersMapper ordersMapper;

    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public boolean save() {
        String productId = "1001";
        Orders order = new Orders();
        order.setUserId("1");
        order.setProductId(productId);
        order.setCount(5);
        order.setStatus(1);
        ordersMapper.insert(order);
        System.out.println("save order ");
        String result = stockFeignClient.reduceStock(productId);
        System.out.println("reduce stock :" + result);
        // 模拟异常
        result.substring(10, 2);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean reduceOrder(String productId) {
        System.out.println("Order:start , productId:" + productId);
        int count = ordersMapper.reduceStock(productId);
        System.out.println("Order:reduce , count:" + count);
        return count > 0;
    }
}
