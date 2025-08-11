package org.example.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.order.dto.Orders;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Update("UPDATE orders SET money = money - 1 WHERE product_id = #{productId} AND count > 0")
    int reduceStock(@Param("productId") String productId);
}