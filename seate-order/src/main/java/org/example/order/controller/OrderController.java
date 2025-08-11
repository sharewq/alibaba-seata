package org.example.order.controller;

import org.example.order.dto.Orders;
import org.example.order.mapper.OrdersMapper;
import org.example.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    public OrdersMapper ordersMapper;
    @Resource
    public OrderService orderService;

    @RequestMapping("/order/get")
    public String cpuHig() {
        List<Orders> ordersList = ordersMapper.selectList(null);
        System.out.println("order,size:" + ordersList.size());
        return "order";
    }

    /**
     * 创建订单
     * http://127.0.0.1:8082/order/save
     *
     * @return
     */
    @RequestMapping("/order/save")
    public String save() {
        System.out.println("start save order");
        orderService.save();
        return "order";
    }

    @PostMapping("/order/reduce")
    public String reduceOrder(@RequestParam String productId) {
        System.out.println("start reduce order");
        boolean result = orderService.reduceOrder(productId);
        return "order:" + result;
    }
}
