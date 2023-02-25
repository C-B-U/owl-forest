package com.cbu.backend.global.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogIntroduction {
    @Pointcut("execution(* com.cbu.backend..*Controller*.*(..))")
    public void allController(){}

    @Pointcut("execution(* com.cbu.backend..*Service*.*(..))")
    public void allService(){}

    @Pointcut("execution(* com.cbu.backend..*Repository*.*(..))")
    public void allRepository(){}

    @Around("allController() || allService() || allRepository()")
    public Object controllerLog(ProceedingJoinPoint joinPoint) {
        log.info(
                "METHOD : {}, ARGS : {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
        try {
            Object result = joinPoint.proceed();
            log.info("METHOD : {}, RESULT : {}", joinPoint.getSignature().toShortString(), result);
            return result;
        } catch (Throwable e) {
            return null;
        }
    }
}
