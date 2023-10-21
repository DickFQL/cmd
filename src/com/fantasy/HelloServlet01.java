package com.fantasy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //utf-8
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("GBK");
        String username=request.getParameter("username");
        String passwd = request.getParameter("password");
        response.getWriter().print("你好");
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnerction();
            preparedStatement = connection.prepareStatement("select * from users where username=? and password=? ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,passwd);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username1 = resultSet.getString("username");
                response.getWriter().print("用户"+username1+"你好，登录成功\n");
                response.getWriter().print("success");
            }
            else response.getWriter().print("密码或错误");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.throwexception(connection,preparedStatement,resultSet);
        }


        //response.sendRedirect("a.jsp");

    }
}
