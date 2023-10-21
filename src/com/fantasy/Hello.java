package com.fantasy;

import javax.servlet.*;
import java.io.IOException;

public class Hello implements Servlet {


        @Override
        public void init(ServletConfig servletConfig) {
            System.out.println("Servlet正在初始化");
        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet正在提供服务");
    }




        @Override
        public String getServletInfo() {
            return null;
        }

        @Override
        public void destroy() {
            System.out.println("Servlet正在销毁");
        }

}
