package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //将当前bean配置为Spring中的切面类
public class FirstAspect {
    @Pointcut("execution(* cn.tedu.service..*(..))")
    public void mx(){
    }
    @After("mx()")
    public void myAfter(){
        System.out.println("#first..after..");
    }
    @AfterThrowing(value="mx()",throwing = "e")
    public void myAfterThrowing(Exception e){
        System.out.println("#first..afterThrowing.."+e);
    }
    @AfterReturning(value="mx()",returning = "retObj")
    public void myAfterReturning(Object retObj){
        System.out.println("#first..afterReturning.."+retObj);
    }
    @Around("mx()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("#first..around..before..");
        Object retObj = pjp.proceed();
        System.out.println("#first..around..after..");
        return retObj;
    }
    @Before("mx()")
    public void myBefore(){
        System.out.println("#first..before..");
    }
}
