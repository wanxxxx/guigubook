package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map values, T bean){
        //req.getParameterMap()替换为Map，使得该函数dao层service层也能调用此函数，降低web层的耦合度

        try {
            User user=new User();
            System.out.println("注入之前的user："+bean);
            BeanUtils.populate(bean,values);
            System.out.println("注入之后的user："+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt,int defaultvalue){
        try {
            if(strInt!=null)
                return Integer.parseInt(strInt, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultvalue;
    }

}
