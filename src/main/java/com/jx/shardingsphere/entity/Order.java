package com.jx.shardingsphere.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jx.shardingsphere.entity.enums.OrderStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangjx
 * @since 2021-01-17
 */

@TableName("t_order")
@Data
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id",type = IdType.ASSIGN_ID)
    private Long orderId;
    @TableField("user_id")
    private Integer userId;

    /**
     * 订单状态 NEW,CANCEL,PAID,FINISH
     */
    private OrderStatusEnum status;

    private LocalDateTime time;

    private BigDecimal amount;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
