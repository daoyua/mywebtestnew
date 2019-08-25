package com.test.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet", urlPatterns = "/c", loadOnStartup = 1, initParams = {@WebInitParam(name = "haha", value = "hh")})
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getParameter("username")

        //相应cookie
        response.setContentType("text/html ; charset =UTF-8");
        Cookie cookie = new Cookie("name", "zhangshan");
        cookie.setMaxAge(-1);
        cookie.setDomain("ithei.com");
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("age", "12");
        cookie2.setPath("/c");
        response.addCookie(cookie2);
        response.getWriter().write("请求成功了");


        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {

                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
            }
        }
//有效期 ，默认关闭浏览器没有

    }
}
