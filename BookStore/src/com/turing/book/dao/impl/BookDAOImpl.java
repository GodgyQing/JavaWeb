package com.turing.book.dao.impl;

import com.turing.book.dao.BookDAO;
import com.turing.book.pojo.Book;
import com.turing.book.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public List<Book> bookList() {
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<Book> books = queryRunner.query(JDBCUtils.getConnection(),
                    "select * from book",
                    new BeanListHandler<Book>(Book.class));
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(Book book){
        String sql = "insert into book(bid, bname, author, price) values(?,?,?)";
        QueryRunner qr = new QueryRunner();
        try {
            qr.insert(JDBCUtils.getConnection(),sql,new ScalarHandler<>(),book.getBid(),book.getBname(),book.getAuthor(),book.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book.getBid();
    }

    @Override
    public int del(Integer bid) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            int rows = queryRunner.update(JDBCUtils.getConnection(),
                    "delete from book where bid = ?",
                    bid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
