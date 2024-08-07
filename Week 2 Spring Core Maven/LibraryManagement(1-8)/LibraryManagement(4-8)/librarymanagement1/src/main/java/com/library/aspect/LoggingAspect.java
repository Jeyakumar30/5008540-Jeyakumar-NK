package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.library.service.*.*(..))")
    public void serviceMethods() {}

    // Before advice
    @Before("serviceMethods()")
    public void logBefore() {
        System.out.println("LoggingAspect: Method execution start");
    }

    // After advice
    @After("serviceMethods()")
    public void logAfter() {
        System.out.println("LoggingAspect: Method execution end");
    }
}