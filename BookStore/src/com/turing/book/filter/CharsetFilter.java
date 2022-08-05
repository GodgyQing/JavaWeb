package com.turing.book.filter;

import com.turing.book.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter",urlPatterns = "/*")
public class CharsetFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 请求路径
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        // 权限
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if("/BookStore/".equals(requestURI) || "/BookStore/user".equals(requestURI) || "/BookStore/index.html".equals(requestURI)){
            chain.doFilter(request, response);
        }else{
            if(user == null){ // 没有登录
              resp.sendRedirect("index.html");
            }else{
                chain.doFilter(request, response);
            }
        }
    }
}
