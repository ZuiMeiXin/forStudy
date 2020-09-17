package com.hisoft.logger;

import lombok.Data;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Data
@Component("logger")
@Aspect //说明该类是一个增强类
public class ServiceLogger {
    @Pointcut("execution(public * com.hisoft.service..*.*(..))")
    public void pointcut(){}

    private static org.apache.log4j.Logger logger = Logger.getLogger(ServiceLogger.class);

    //    前置增强
    @Before("pointcut()")
    public static void before(JoinPoint joinPoint) {
        logger.info("前置增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，传入参数："
                + Arrays.toString(joinPoint.getArgs()));
    }

    //    后置增强
    @AfterReturning(value = "pointcut()", returning = "result")
    public static void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("后置增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，返回值为：" + result);
    }


    @AfterThrowing(value = "pointcut()",throwing = "e")
    //    异常抛出增强
    public static void afterThrowing(JoinPoint joinPoint, Exception e) {
        logger.info("异常增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，抛出异常：" + e);
    }

    //    最终增强
    @After("pointcut()")
    public static void after(JoinPoint joinPoint) {
        logger.info("最终增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，方法执行结束");
    }

    //    环绕增强
    @Around(value = "pointcut()")
    public static void around(ProceedingJoinPoint joinPoint) {
        logger.info("环绕增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，参数列表" + Arrays.toString(joinPoint.getArgs()));
        Object result = null;
        try {
            result = joinPoint.proceed();//执行目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("环绕增强：调用了" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，异常：" + throwable);
        } finally {
            logger.info("环绕增强：方法执行结束，调用" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法，返回值为：" + result);
        }
    }


}

