package com.wang.zsxt.interceptor;

import com.wang.zsxt.tool.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域请求携带Authorization头部
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        // 如果是OPTIONS请求，则直接返回true
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        
        // 如果请求头中没有token，则尝试从参数中获取
        if (token == null || token.isEmpty()) {
            token = request.getParameter("token");
        }

        // 如果仍然没有token，则拒绝访问
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"message\":\"缺少Token，请先登录\"}");
            return false;
        }

        // 验证token是否有效
        // 去除Bearer前缀（如果存在）
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        if (JwtUtil.validateToken(token)) {
            try {
                Claims claims = JwtUtil.parseToken(token);
                // Token有效，继续执行
                request.setAttribute("claims", claims);
                return true;
            } catch (Exception e) {
                // Token解析失败，返回401状态码
                response.setStatus(401);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":401,\"message\":\"Token无效或已过期，请重新登录\"}");
                return false;
            }
        } else {
            // Token无效，返回401状态码
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"message\":\"Token无效或已过期，请重新登录\"}");
            return false;
        }
    }
}