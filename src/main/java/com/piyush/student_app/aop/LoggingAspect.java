package com.piyush.student_app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.piyush.student_app.service.StudentService.addStudent(..))")
    public void LogMethodCalled(JoinPoint jp){
        LOGGER.info("Method Called : "+jp.getSignature().getName());
    }

    @After("execution(* com.piyush.student_app.service.StudentService.updateStudent(..))")
    public void MethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed : "+jp.getSignature().getName());
    }
}
