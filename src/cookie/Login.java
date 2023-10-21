package cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Cookie[] cookies = request.getCookies();
        if (cookies.length != 0) for (Cookie cookie: cookies){
            if ("cookie1".equals(username) && "dickfuck".equals(password)) {
                response.addCookie(cookie);
                response.getWriter().println("<script>alert(\"login success\")</script>");
//                response.sendRedirect("http://127.0.0.1:8081/cmd/login.jsp");
            }
        }
        else {
            if ("cookie1".equals(username) && "dickfuck".equals(password)) {
                response.addCookie(new Cookie("username","password"));
                response.getWriter().println("<script>alert(\"login success\")</script>");
            }
        }
        response.getWriter().println("<script>alert(\"login fail\")</script>");
//        response.sendRedirect("http://127.0.0.1:8081/cmd/login.jsp");

    }
}
