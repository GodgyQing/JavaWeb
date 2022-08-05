package com.turing.book.web;

import com.alibaba.fastjson.JSON;
import com.turing.book.dao.UserDAO;
import com.turing.book.dao.impl.UserDAOImpl;
import com.turing.book.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String method = req.getParameter("method");

        HttpSession session = req.getSession();

        if("login".equals(method)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = userDAO.login(username, password);
            if(user == null){
                resp.sendRedirect("index.html");
            }else{
                // 登录成功存放user的信息
                session.setAttribute("user", user);
                resp.sendRedirect("book.html");
            }
        }
        if("userinfo".equals(method)){
            User user = (User) session.getAttribute("user");
            resp.getWriter().write(JSON.toJSONString(user));
        }
        if("logout".equals(method)){
            session.invalidate();
        }

        /*
         创建cookie
        Cookie cookie = new Cookie("name","zs");
        resp.addCookie(cookie);


        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if("name".equals(cookie.getName())){
                System.out.println(cookie.getValue());
            }
        }
        */


//        session.invalidate();// 删除session

    }

}
