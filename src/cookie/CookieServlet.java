package cookie;

import cookie.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/cookieservlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        添加cookie到浏览器
        addCookie(request,response);
//        获取cookie
        getCookie(request,response);
//      找寻cookie
        findCookie(request,response);
    }

    private void findCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie: cookies){
//            if (cookie.getName().equals("cookie1")) {
//                try {
//                    response.getWriter().println("寻找Cookie成功："+cookie.getName()+":"+cookie.getValue()+"<br>");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
        String key = "cookie1";
        Cookie cookie = CookieUtil.serarchCookie(cookies, key);


        try {
            response.getWriter().println("寻找Cookie成功："+cookie.getName()+":"+cookie.getValue()+"<br>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("cookie1","dickfuck");
        Cookie cookie1 = new Cookie("cookie2", "dickduck");
        Cookie cookie2 = new Cookie("cookie3","fuck");
        cookie2.setMaxAge(60*60*24 );
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().println("浏览器保持cookie成功<br>");
    }


    private void getCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            response.getWriter().println(cookie.getName()+":"+cookie.getValue()+"<br>");
        }
    }
}
