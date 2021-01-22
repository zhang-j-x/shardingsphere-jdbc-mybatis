package com.jx.shardingsphere.service;


import com.jx.shardingsphere.entity.Order;

import java.util.List;

public interface IOrderService {

    void insertSharding();

    /**
     * 广播查询
     * @return
     */
    List<Order> qryOrdersBroadcast();

    /**
     * 通过userId指定库查询
     * @return
     */
    List<Order> qryOrdersByUserId();

    /**
     * 指定orderId查询
     * @return
     */
    Order qryOrderByOrderId();


    /**
     * 指定userId和orderId查询
     * @return
     */
    Order qryOrderByUserIdAndOrderId();


    /**
     * 分页查询
     */
    List<Order> qryOrdersByPage();

    void update();

    List<Order> subQuery();


    /**
     * 读写分离指定主库查询
     * @return
     */
    List<Order> qryOrdersByUserIdFromMaster();
}
