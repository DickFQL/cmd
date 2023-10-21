package servletjsp.servlet;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public CookieUtil() {
    }
    public static Cookie serarchCookie(Cookie[] cookies,String key){
        for (Cookie cookie: cookies)
            if (cookie.getName().equals(key)) return cookie;
        return null;
    }
}
