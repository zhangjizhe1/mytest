package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class UseTimeAspect {
    @Around("execution(* cn.tedu.service..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //目标对象
        Object target = pjp.getTarget();
        Class<?> clz = target.getClass();

        //目标方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        long begin = System.currentTimeMillis();
        Object retObj = pjp.proceed();
        long end = System.currentTimeMillis();
        long use = end - begin;

        System.out.println("###耗时统计,["+clz+"]类的["+method+"]方法执行耗时["+use+"]毫秒####");

        return retObj;
    }
}
