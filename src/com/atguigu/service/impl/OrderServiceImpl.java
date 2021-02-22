package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //先生成一个新订单并保存
        String orderId=System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);
        //将选中的购物车商品转换为订单项
        for (Map.Entry<Integer,CartItem>entry:cart.getItems().entrySet()) {
            CartItem cartItem=entry.getValue();

            OrderItem orderItem = new OrderItem(
                    cartItem.getId(),
                    cartItem.getName(),
                    cartItem.getCount(),
                    cartItem.getPrice(),
                    cartItem.getTotalPrice(),
                    orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);

        }
        //将选中的购物车商品从购物车中删除
        cart.clear();

        return orderId;
    }
}
