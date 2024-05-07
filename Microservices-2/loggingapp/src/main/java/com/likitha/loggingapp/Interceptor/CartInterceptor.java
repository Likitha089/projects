package com.likitha.loggingapp.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartInterceptor implements HandlerInterceptor {

    final Logger log = LoggerFactory.getLogger(CartInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String userId = request.getHeader("userId");

            if (userId.length() != 4 ) {
                log.warn("UserId should be of length 4");
                ResponseEntity<String> errorResponse = ResponseEntity.badRequest().body(
                        "UserId should be of length 4");
                response.getWriter().write(errorResponse.getBody());
                response.setStatus(401);
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("Internal Server Error", e.getMessage());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info(" Inside Posthandle.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("Inside aftercompletion");
    }

}
