package com.atguigu.test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("login方法调用");
    }

    public static void main(String[] args) {
        String action="login";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
