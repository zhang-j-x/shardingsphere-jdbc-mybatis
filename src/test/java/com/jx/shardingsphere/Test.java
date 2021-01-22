package com.jx.shardingsphere;

import com.jx.shardingsphere.service.IOrderService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: zhangjx
 * @Date: 2021-01-17 13:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private IOrderService orderService;

    @org.junit.Test
    public void testSharding(){
//        orderService.insertSharding();
//        orderService.qryOrdersBroadcast();
//        orderService.qryOrdersByUserId();
//        orderService.qryOrderByOrderId();
//        orderService.qryOrderByUserIdAndOrderId();
//        orderService.qryOrdersByPage();
//        orderService.update();
//        orderService.subQuery();
        orderService.qryOrdersByUserIdFromMaster();
        orderService.qryOrdersByUserId();
    }



}
