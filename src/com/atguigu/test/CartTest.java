package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"a",1,new BigDecimal(87),new BigDecimal(87)));
        cart.addItem(new CartItem(1,"a",1,new BigDecimal(87),new BigDecimal(87)));
        cart.addItem(new CartItem(2,"b",2,new BigDecimal(3),new BigDecimal(6)));
        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateItem() {
    }
}