package org.example.order.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("orders")
public class Orders {

    @TableId
    private Long id;

    private String userId;

    private String productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;
}
