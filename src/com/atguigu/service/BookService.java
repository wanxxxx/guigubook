package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    //分页功能
    public Page<Book> page(Integer pageNo, Integer pageSize);

    //价格区间功能
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize,Integer min, Integer max);

}
