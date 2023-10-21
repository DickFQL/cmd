package com.fantasy;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 *
 */
public class HelloServlet02 implements Servlet {
    public HelloServlet02() {
        System.out.println("1、创建当前实例");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、执行init初始化方法，初始化对应数据");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、执行service方法，获取请求和响应对象");
    }

    @Override
    public String getServletInfo() {

        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、执行销毁方法");
    }
}
