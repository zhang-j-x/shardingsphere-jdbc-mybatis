package com.jx.shardingsphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.shardingsphere.entity.Order;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangjx
 * @since 2021-01-17
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> subQuery();

}
