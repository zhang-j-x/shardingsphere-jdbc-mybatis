package com.jx.shardingsphere.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jx.shardingsphere.dao.OrderMapper;
import com.jx.shardingsphere.entity.Order;
import com.jx.shardingsphere.entity.enums.OrderStatusEnum;
import com.jx.shardingsphere.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: zhangjx
 * @Date: 2021-01-18 10:46
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void insertSharding(){
        long start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(e -> {
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

    @Override
    public List<Order> qryOrdersBroadcast() {
        long start = System.currentTimeMillis();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Order::getStatus,OrderStatusEnum.NEW);
        List<Order> orders = orderMapper.selectList(wrapper);
        System.out.println(JSON.toJSONString(orders));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return orders;
    }

    @Override
    public List<Order> qryOrdersByUserId() {
        long start = System.currentTimeMillis();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Order::getUserId,1);
        List<Order> orders = orderMapper.selectList(wrapper);
        System.out.println(JSON.toJSONString(orders));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return orders;
    }

    @Override
    public Order qryOrderByOrderId() {
        long start = System.currentTimeMillis();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Order::getOrderId,1350972052163067905L);
        Order order = orderMapper.selectOne(wrapper);
        System.out.println(JSON.toJSONString(order));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return order;
    }

    @Override
    public Order qryOrderByUserIdAndOrderId() {
        long start = System.currentTimeMillis();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Order::getUserId,1);
        wrapper.lambda().eq(Order::getOrderId,1350972052163067905L);
        Order order = orderMapper.selectOne(wrapper);
        System.out.println(JSON.toJSONString(order));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return order;
    }

    @Override
    public List<Order> qryOrdersByPage() {
        long start = System.currentTimeMillis();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Order::getStatus,OrderStatusEnum.NEW);
        wrapper.lambda().orderByAsc(Order::getTime);
        IPage<Order> page = new Page<Order>(1,5);
        IPage<Order> result = orderMapper.selectPage(page, wrapper);

        System.out.println(JSON.toJSONString(result.getRecords()));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return result.getRecords();
    }

    @Override
    public void update() {
        long start = System.currentTimeMillis();
        Order order = new Order();
        order.setStatus(OrderStatusEnum.FINISH);
        UpdateWrapper<Order> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Order::getUserId,1);
        orderMapper.update(order,wrapper);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public List<Order> subQuery() {
        return orderMapper.subQuery();
    }
}
