package org.example.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.stock.dto.Stock;

@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    @Update("UPDATE stock SET residue = residue - 1, used = used + 1 WHERE product_id = #{productId} AND residue > 0")
    int reduceStock(@Param("productId") String productId);
}
