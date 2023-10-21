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

@WebServlet("/hello03")
public class ServletConfigTest2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();

        //获取全局域对象
        ServletContext servletContext = servletConfig.getServletContext();

        //获取当前资源的全类名
        String servletName = servletConfig.getServletName();

        //获取局部配置信息
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");

        //获取所有初始化key的集合
        Enumeration<String> initParametername = servletConfig.getInitParameterNames();

        //遍历集合
        while ( initParametername.hasMoreElements()){
            String key = initParametername.nextElement();
            String value = servletConfig.getInitParameter(key);
            System.out.println(key+" "+value);
        }
        /*resp.getWriter().print(servletName);
        resp.getWriter().print("\n");
        resp.getWriter().print(username+""+password);*/
    }
}
