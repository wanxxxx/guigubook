package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

public interface OrderDao {

    public Order queryOrderByUserId(int UserId);

    public List<Order> queryOrders();

    public int changeOrderStatus(Integer status, Integer id);

    public int saveOrder(Order order);

}
