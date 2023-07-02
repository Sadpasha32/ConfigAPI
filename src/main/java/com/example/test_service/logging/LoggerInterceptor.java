package com.example.test_service.logging;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {
    public static final String SERVICE = "SERVICE";
    public static final String CONFIG_UUID = "CONFIG_UUID";
    public static final String HOST_NAME = "HOST_NAME";
    public static final String PORT_NUMBER = "PORT_NUMBER";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put(SERVICE,"[CONFIG]");
        MDC.put(HOST_NAME,request.getServerName());
        MDC.put(PORT_NUMBER, String.valueOf(request.getServerPort()));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.clear();
    }
}
