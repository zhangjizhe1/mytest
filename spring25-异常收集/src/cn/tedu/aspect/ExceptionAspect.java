package cn.tedu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class ExceptionAspect {
    @AfterThrowing(value="execution(* cn.tedu.service..*(..))",throwing = "e")
    public void afterThrowing(JoinPoint jp,Throwable e){
        //获取目标对象
        Object target = jp.getTarget();
        Class clz = target.getClass();
        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();

        System.out.println("##发生异常，在["+clz+"]的["+method+"]方法中出现["+e+"]异常##");
    }
}
