package com.turing.book.web;

import com.alibaba.fastjson.JSON;
import com.turing.book.dao.BookDAO;
import com.turing.book.dao.impl.BookDAOImpl;
import com.turing.book.pojo.Book;
import com.turing.book.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            String method = req.getParameter("method");
            String bid = req.getParameter("bid");

            if("del".equals(method)){
                int del = bookDAO.del(Integer.parseInt(bid));
                resp.getWriter().write(del);
            }

            if("queryAll".equals(method)){
                List<Book> books = bookDAO.bookList();
                if(books != null){
                    resp.getWriter().write(JSON.toJSONString(books));
                }
            }
    }
}
