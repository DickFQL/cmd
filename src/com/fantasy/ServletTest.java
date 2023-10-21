package com.fantasy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("hello");
        response.getWriter().println("hello2");
        response.getWriter().flush();
        response.getWriter().close();

    }
}
