package com.fantasy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello05")
public class HelloServlet05 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();

        //获取全局域对象
        ServletContext servletContext = servletConfig.getServletContext();
        //通过域对象去存储数据
        servletContext.setAttribute("name","jack");
        servletContext.setAttribute("age","10");
    }
}
