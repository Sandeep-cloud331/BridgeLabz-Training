package com.example.contacts_app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("@annotation(com.example.contacts_app.annotation.LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Method started: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Method ended: " + joinPoint.getSignature().getName());
        return result;
    }
}
