package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
