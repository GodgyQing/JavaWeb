package com.turing.book.dao.impl;

import com.turing.book.dao.UserDAO;
import com.turing.book.pojo.Book;
import com.turing.book.pojo.User;
import com.turing.book.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public User login(String username, String password) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            User user = queryRunner.query(JDBCUtils.getConnection(),
                    "select * from user where username = ? and password = ?",
                    new BeanHandler<User>(User.class),
                    username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
