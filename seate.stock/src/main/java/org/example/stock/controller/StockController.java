package org.example.stock.controller;

import org.example.stock.dto.Stock;
import org.example.stock.mapper.StockMapper;
import org.example.stock.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StockController {

    @Resource
    private StockMapper stockMapper;
    @Resource
    private StockService stockService;

    @RequestMapping("/stock/get")
    public String cpuHig() {
        List<Stock> list = stockMapper.selectList(null);
        System.out.println("stock,size:" + list.size());
        return "stock";
    }

    @PostMapping("/stock/reduce")
    public String reduce(@RequestParam String productId) {
        stockService.reduceStock(productId);
        return "reduce";
    }

    /**
     * http://127.0.0.1:8081/stock/save
     * @return
     */
    @RequestMapping("/stock/save")
    public String save() {
        System.out.println("start save stock");
        stockService.save();
        return "stock";
    }
}
