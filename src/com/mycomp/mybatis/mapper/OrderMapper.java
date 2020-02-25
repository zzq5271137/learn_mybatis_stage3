package com.mycomp.mybatis.mapper;

import com.mycomp.mybatis.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * 一对多的相关操作
 */

public interface OrderMapper {

    // 查询所有的Order, 并且查询出所有相应的Customer
    List<Order> getAllOrders();

    // 分步查询
    Order getOrderById(Integer id);

    // 插入一条订单信息, 并关联好相应的外键
    void insertOrder(Order order);

    // 根据cust_id查询订单
    List<Order> getOrderByCustId(Integer id);

    // 更新关系
    void updateOrderCustId(@Param("order_id") Integer orderId, @Param("cust_id") Integer custId);

    // 打破关系
    void updateRelation(Integer cust_id);
}
