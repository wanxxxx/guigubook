package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"a",1, new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(2,"b",2, new BigDecimal(10),new BigDecimal(20)));
        cart.addItem(new CartItem(3,"c",3, new BigDecimal(10),new BigDecimal(30)));

        System.out.println("订单号："+orderService.createOrder(cart,1));
    }
}