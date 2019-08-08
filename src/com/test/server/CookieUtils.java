package com.test.server;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     *
     * @param cookies
     * @param name
     * @return
     */
    public   static Cookie findCookie(Cookie[] cookies, String name) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
