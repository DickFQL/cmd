package com.fantasy;

import java.sql.*;

public class JDBCUtils {
    private JDBCUtils(){
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获得数据库连接对象
    public static Connection getConnerction() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","rootroot");
    }

    public static void throwexception(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(statement!=null){
            try{
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if(connection!=null){
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
