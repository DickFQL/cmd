package com.fantasy;

import sun.nio.cs.ext.GBK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
//        响应的文本类型，已经显示的字符集
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        resp.getWriter().println("\n");
//        resp.getWriter().println("</br>");
        resp.getWriter().println("hello "+name+" you password is:"+password);
    }
}
