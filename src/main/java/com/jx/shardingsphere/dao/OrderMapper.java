package com.jx.shardingsphere.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jx.shardingsphere.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangjx
 * @since 2021-01-17
 */
public interface OrderMapper extends BaseMapper<Order> {

    IPage<Order> qryOrderPage(IPage<Order> page,@Param("userId") Integer userId);

}
