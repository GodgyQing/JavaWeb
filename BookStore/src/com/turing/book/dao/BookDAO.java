package com.turing.book.dao;

import com.turing.book.pojo.Book;

import java.util.List;

public interface BookDAO {

    List<Book> bookList();

    int add(Book book);

    int del(Integer bid);

}
