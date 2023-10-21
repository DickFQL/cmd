package com.fantasy;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class ServletConfigTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletConfig servletConfig = getServletConfig();

        //获取全局域对象
        ServletContext servletContext = servletConfig.getServletContext();
        //获取当前资源的全类名
        String servletName = servletConfig.getServletName();
        //获取局部配置信息（用键获取值）
        String initParameter = servletConfig.getInitParameter("username");
        String initParameter2 = servletConfig.getInitParameter("password");
        //获取所有初始化key的集合
        Enumeration<String> initParametername = servletConfig.getInitParameterNames();
        while (initParametername.hasMoreElements()){
            String username = initParametername.nextElement();
            String password = servletConfig.getInitParameter(username);
            response.getWriter().println(username+" : "+password);
        }

    }
}
