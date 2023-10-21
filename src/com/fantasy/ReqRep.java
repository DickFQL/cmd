package com.fantasy;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ReqRep extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("gbk");
        response.setCharacterEncoding("gbk");
        //response.setContentType("text/html;charset=utf-8");
        String method = request.getMethod();
        response.getWriter().println(method);
        Cookie[] cookies = request.getCookies();
        response.getWriter().println(cookies);
        String contextPath = request.getContextPath();
        response.getWriter().println(contextPath);
        String authType = request.getAuthType();
        response.getWriter().println(authType);
        String dateHeader = request.getHeader("User-Agent");
        response.getWriter().println(dateHeader);
        String servletPath = request.getServletPath();
        response.getWriter().println(servletPath);
//        获取多个参数

        String[] cookies1 = request.getParameterValues("coo");
        for (String cookie : cookies1){
            System.out.println(cookie);
        }

        for (String cookie : cookies1){
            response.getWriter().println(cookie);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();

        out.write("1qaz@WSX");
        out.println("Hello World!哈哈");
        out.println();
        out.flush();
        out.close();
    }

}
