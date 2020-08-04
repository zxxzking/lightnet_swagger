package com.lightnet.handler;

import com.lightnet.annotation.UserAuthenticate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        UserAuthenticate annotation = method.getAnnotation(UserAuthenticate.class);
        if (null != annotation) {
            System.out.println("==========");
            System.out.println(annotation.capability());
        }

        return true;
    }


}
