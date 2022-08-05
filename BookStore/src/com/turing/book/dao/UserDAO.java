package com.turing.book.dao;

import com.turing.book.pojo.User;

public interface UserDAO {

    User login(String username,String password);

}
