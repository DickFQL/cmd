package servletjsp.servlet;

import com.fantasy.JDBCUtils;
import servletjsp.stu.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentservlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        if (method != null){
            if (method.equals("list")){
                try {
                    this.getList(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (method.equals("add")){
                try {
                    this.add(req,resp);
//                    this.getList(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (method.equals("delete")){
                try {
                    this.delete(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
//                    this.getList(req,resp);
            }
            if (method.equals("changeview")){
                try {
                    this.changeview(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (method.equals("change")){
                try {
                    this.change(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (method.equals("login")){
                this.login(req,resp);
            }
            if (method.equals("reg")){
                this.reg(req,resp);
            }
        }
    }

    private void reg(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        String id = request.getParameter("id");
        String lastname = request.getParameter("username");

        String password = request.getParameter("password");
        try {
//           获取数据库对象
            connection = JDBCUtils.getConnerction();
//            获取数据库操作对象，预编译sql
            preparedStatement = connection.prepareStatement("insert into dvwa.users(user_id,last_name,password) values(?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(id));
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,password);
//            执行sql
            resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1){
                response.sendRedirect("http://127.0.0.1:8081/cmd/html/login.jsp");
                 response.getWriter().println("<script>alert(\"注册成功\")</script>");
            }
            else {
                response.sendRedirect("http://127.0.0.1:8081/cmd/html/reg.jsp");
                response.getWriter().println("<script>alert(\"注册失败\")</script>");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultSet resultSet=null;
        try {
            connection = JDBCUtils.getConnerction();
            preparedStatement = connection.prepareStatement("select * from dvwa.users where last_name=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet !=null && resultSet.next()){
                HttpSession session = request.getSession();

                int id2 = resultSet.getInt("user_id");
                String firstname = resultSet.getString("first_name");
                String user =resultSet.getString("user");
                Student student = new Student(id2,firstname,username,user,password);
                session.setAttribute("session",student);
                request.getRequestDispatcher("/servletjsp?method=list").forward(request,response);
//                response.sendRedirect("http://127.0.0.1:8081/cmd/servletjsp?method=list");
            }
            else {
                response.getWriter().println("登录失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }

    public void change(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        String id = request.getParameter("id");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnerction();
            preparedStatement = connection.prepareStatement("update dvwa.users set last_name=?,first_name=?,user=?,password=? where user_id=?");
            preparedStatement.setString(1, lastname);
            preparedStatement.setString(2,firstname);
            preparedStatement.setString(3,user);
            preparedStatement.setString(4,password);
            preparedStatement.setInt(5,Integer.parseInt(id));

            resultSet = preparedStatement.executeUpdate();

            if (resultSet ==1 ){
                response.sendRedirect("http://127.0.0.1:8081/cmd/servletjsp?method=list");
            }
            else {
                System.out.println("没查到");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    public void changeview(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String id = request.getParameter("id");
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnerction();
            preparedStatement = connection.prepareStatement("select * from dvwa.users where user_id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            resultSet = preparedStatement.executeQuery();
            while (resultSet!=null && resultSet.next()){
                int id2 = resultSet.getInt("user_id");
                String firstname = resultSet.getString("first_name");
                String lastname =resultSet.getString("last_name");
                String user =resultSet.getString("user");
                String password =resultSet.getString("password");
                Student student = new Student(id2, firstname, lastname, user, password);
                arrayList.add(student);
            }
            if (arrayList != null ){
                request.setAttribute("changeview",arrayList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/change.jsp");
                requestDispatcher.forward(request,response);

            }
            else {
                System.out.println("没查到");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            connection = JDBCUtils.getConnerction();
            preparedStatement = connection.prepareStatement("delete from dvwa.users where user_id=?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1 ){
                response.sendRedirect("http://127.0.0.1:8081/cmd/servletjsp?method=list");
            }
            else {
                System.out.println("删除失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        ArrayList<Student> arrayList = new ArrayList<>();
        String id = request.getParameter("id");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        try {
//           获取数据库对象
            connection = JDBCUtils.getConnerction();
//            获取数据库操作对象，预编译sql
            preparedStatement = connection.prepareStatement("insert into dvwa.users(user_id,first_name,last_name,user,password) values(?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(id));
            preparedStatement.setString(2,firstname);
            preparedStatement.setString(3,lastname);
            preparedStatement.setString(4,user);
            preparedStatement.setString(5,password);
//            执行sql
            resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1){
                response.sendRedirect("http://127.0.0.1:8081/cmd/servletjsp?method=list");
                System.out.println("添加成功");
            }
            else {
                response.getWriter().println("添加失败");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            connection.close();
        }

    }

    public void getList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Student> arrayList = new ArrayList<>();

        try {
//           获取数据库对象
            connection = JDBCUtils.getConnerction();
//            获取数据库操作对象，预编译sql
            preparedStatement = connection.prepareStatement("select * from dvwa.users");
//            执行sql
            resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next() ){
//                根据字段取数据
                int id = resultSet.getInt("user_id");
                String firstname = resultSet.getString("first_name");
                String lastname =resultSet.getString("last_name");
                String user =resultSet.getString("user");
                String password =resultSet.getString("password");
                Student student = new Student(id,firstname,lastname,user,password);
//                添加学生对象到集合内
                arrayList.add(student);
            }
            for (Student student : arrayList){
                System.out.println(student);
            }

            request.setAttribute("test",arrayList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/stujsp.jsp");
            requestDispatcher.forward(request,response);

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            connection.close();
        }
    }
}
