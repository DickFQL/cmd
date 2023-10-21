package com.fantasy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/hello04")
public class HelloServlet04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();

        //获取全局域对象
        ServletContext servletContext = servletConfig.getServletContext();
        //取出域中的数据
        Object name = servletContext.getAttribute("name");
        Object age = servletContext.getAttribute("age");
        System.out.println(name+" "+age+"\n");

        //获取工程路径/web
        String contextPath = servletContext.getContextPath();
        resp.getWriter().print(contextPath);
        //获取全局配置信息
        //servletContext.getInitParameter();
        String url = servletContext.getInitParameter("url");
        resp.getWriter().print(url);
    }
}
