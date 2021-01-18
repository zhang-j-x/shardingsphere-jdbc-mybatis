package com.jx.shardingsphere;

import com.jx.shardingsphere.dao.OrderMapper;
import com.jx.shardingsphere.entity.Order;
import com.jx.shardingsphere.entity.enums.OrderStatusEnum;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: zhangjx
 * @Date: 2021-01-17 13:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private OrderMapper orderMapper;

    /***
     * 20条数据耗时 900ms左右
     * 100条数据耗时 1400ms左右
     */
    @org.junit.Test
    public void insertSharding(){
        long start = System.currentTimeMillis();
        IntStream.range(1,100).forEach( e -> {
            Order order = new Order();
            order.setUserId(e);
            order.setStatus(OrderStatusEnum.NEW);
            order.setTime(LocalDateTime.now());
            order.setAmount(BigDecimal.valueOf(new Random().nextInt(200)));
            orderMapper.insert(order);
        });
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
