package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo =WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize =WebUtils.parseInt(req.getParameter("pageSize"), 4);

        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/clientBookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo =WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize =WebUtils.parseInt(req.getParameter("pageSize"), 4);
        System.out.println(req.getParameter("min"));
        int min =WebUtils.parseInt(req.getParameter("min"), 0);
        int max =WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb=new StringBuilder("client/clientBookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
