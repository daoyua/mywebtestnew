package com.test.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");


        ServletConfig servletConfig = getServletConfig();
//        System.out.println( servletConfig.getServletName());
        ServletContext servletContext = getServletContext();
        Properties properties = new Properties();
        //H:\java\mywebtest\out\artifacts\mywebtest_war_exploded\config.properties

//        servletContext
        //相对路径
        InputStream resourceAsStream = servletContext.getResourceAsStream("WEB-INF/files/config.properties");
        properties.load(resourceAsStream);
        //绝对路劲
//        String realPath = servletContext.getRealPath("WEB-INF/files/config.properties");//
//        System.out.println("realPath="+realPath);
//        properties.load(new FileInputStream(realPath));
        String name = properties.getProperty("name");
        System.out.println("name=" + name);
//        servletConfig.getServletName()
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        Object count = getServletContext().getAttribute("count");
        int counts = 0;
        if (count != null) {
            counts = (int) count + 1;
        }
        if ("123".equals(username)) {

            Cookie[] cookies = req.getCookies();
            Cookie lastCookie = CookieUtils.findCookie(cookies, "last");
            if (lastCookie != null) {
                //第二次
                long value = Long.parseLong(lastCookie.getValue());
                writer.write("欢迎" + username+"上次来访时间:"+new Date(value));
                lastCookie.setValue(System.currentTimeMillis()  + "");
                resp.addCookie(lastCookie);
            } else {//没有cookie 第一次
                lastCookie = new Cookie("last", System.currentTimeMillis() + "");                lastCookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(lastCookie);
                writer.write("欢迎" + username);
            }


//            resp.dir
//            resp.setStatus(302);
//            resp.setHeader("Location","success.html");
//            System.out.println("count"+counts);
            getServletContext().setAttribute("count", counts);
        } else {
            writer.write("login failed!");
        }
//        writer.write(username);
//        writer.write(password);
        //****************************************************
        req.getParameter("name");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPOST=");
        doGet(req, resp);
    }
}
