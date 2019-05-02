package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.utils.PageBean;

import java.util.List;


public interface IBookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> listBook(Book book, PageBean pageBean);
}