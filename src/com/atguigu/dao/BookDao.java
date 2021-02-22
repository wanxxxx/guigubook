package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    //增
    public int addBook(Book book);
    //删
    public int deleteBookById(Integer id);
    //改
    public int updateBook(Book book);
    //删，改
    public Book queryBookById(Integer id);

    //列出全部图书，已被分页功能所替换
    public List<Book> queryBooks();

    //分页功能
    Integer queryForPageTotalCount();
    List<Book> queryForPageItems(int begin, int pageSize) ;

    //查询价格区间内图书
    Integer queryForPageTotalCountByPrice(int min,int max);
    List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max) ;


}
