package com.wang.zsxt.tool;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtil {

    /**
     * 从当前请求上下文中获取HttpServletRequest对象
     *
     * @return HttpServletRequest对象，如果不在请求上下文中则返回null
     */
    public static HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    /**
     * 从当前请求中获取JWT Token中的用户名
     *
     * @return 用户名，如果不存在则返回null
     */
    public static String getUsernameFromToken() {
        HttpServletRequest request = getCurrentRequest();
        if (request != null) {
            Claims claims = (Claims) request.getAttribute("claims");
            if (claims != null) {
                return claims.getSubject();
            }
        }
        return null;
    }

    /**
     * 从给定的请求中获取JWT Token中的用户名
     *
     * @param request HttpServletRequest对象
     * @return 用户名，如果不存在则返回null
     */
    public static String getUsernameFromToken(HttpServletRequest request) {
        if (request != null) {
            Claims claims = (Claims) request.getAttribute("claims");
            if (claims != null) {
                return claims.getSubject();
            }
        }
        return null;
    }

    /**
     * 从当前请求中获取JWT Token中的其他信息
     *
     * @param claimName 要获取的声明名称
     * @return 声明值，如果不存在则返回null
     */
    public static Object getClaimFromToken(String claimName) {
        HttpServletRequest request = getCurrentRequest();
        if (request != null) {
            Claims claims = (Claims) request.getAttribute("claims");
            if (claims != null) {
                return claims.get(claimName);
            }
        }
        return null;
    }

    /**
     * 从给定请求中获取JWT Token中的其他信息
     *
     * @param request   HttpServletRequest对象
     * @param claimName 要获取的声明名称
     * @return 声明值，如果不存在则返回null
     */
    public static Object getClaimFromToken(HttpServletRequest request, String claimName) {
        if (request != null) {
            Claims claims = (Claims) request.getAttribute("claims");
            if (claims != null) {
                return claims.get(claimName);
            }
        }
        return null;
    }
}