package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {



        orderDao.saveOrder(new Order("445646",new Date(),new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrderByUserId() {
    }

    @Test
    public void queryOrders() {
        for(Order order:orderDao.queryOrders())
            System.out.println(order);
    }

    @Test
    public void changeOrderStatus() {
    }
}