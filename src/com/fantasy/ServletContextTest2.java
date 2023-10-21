package com.fantasy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletcontexttest2")
public class ServletContextTest2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = getServletConfig().getServletContext();
//        System.out.println(servletContext == servletContext2);
//        获取属性值
        Object a = servletContext.getAttribute("name");
        Object b = servletContext.getAttribute("age");
        resp.getWriter().println("name "+a+" age "+b);
        System.out.println("name "+a+" age "+b);
//      获取工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
//        获取全局域对象
        String initParameter = servletContext.getInitParameter("name");
        resp.getWriter().println(initParameter);
    }
}
