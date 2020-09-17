package com.hisoft.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect//注入增强
public class ServiceLogger {
    private Logger logger = Logger.getLogger(ServiceLogger.class);

    @Pointcut("execution(public * com.hisoft.service..*.*(..))")
    public void pointcut() {
    }


    //    前置增强
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        logger.info("前置增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，传入参数："
                + Arrays.toString(joinPoint.getArgs()));
    }

    //    后置增强
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("后置增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，返回值："
                + result);
    }

//    最终增强

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        logger.info("最终增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，传入参数："
                + Arrays.toString(joinPoint.getArgs()));
    }

//    异常抛出增强
    public void afterThrowing(ProceedingJoinPoint joinPoint,Exception e){
        logger.info("异常抛出增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，抛出异常："
                +e );
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
