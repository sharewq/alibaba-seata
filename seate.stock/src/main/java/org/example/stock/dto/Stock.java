package org.example.stock.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("stock")
public class Stock {

    @TableId
    private Long id;

    private String productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
