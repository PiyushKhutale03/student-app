package com.piyush.student_app.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.piyush.student_app.service.StudentService.addStudent(..)) && args(studentId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int studentId) throws Throwable {
        if (studentId<0) {
            LOGGER.info("PostId is negative, updating it");

            studentId=-studentId;
            LOGGER.info("new Value "+studentId);
        }


        Object obj=jp.proceed(new Object[] {studentId});

        return obj;
    }

}
