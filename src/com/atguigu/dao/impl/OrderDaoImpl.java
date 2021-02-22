package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {


    @Override
    public Order queryOrderByUserId(int UserId) {
        String sql = "select `order_id`,`creat_time`,`price`,`status`,`user_id` from t_order where user_id = ?";
        return queryForOne(Order.class, sql, UserId);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(Integer status, Integer id) {
        String sql = " update t_order set `status`=? where id = ?";
        return update(sql, status, id);

    }

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }


}
