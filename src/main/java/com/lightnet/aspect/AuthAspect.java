package com.lightnet.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    @Pointcut("execution(public * com.lightnet.api.controller.*(..))")
    private void controllerAspect() {}
}
