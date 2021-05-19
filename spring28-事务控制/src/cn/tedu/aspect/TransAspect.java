package cn.tedu.aspect;

import cn.tedu.anno.Trans;
import cn.tedu.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransAspect {

    @Around("execution(* cn.tedu.service..*(..)) && @annotation(ta)")
    public Object around(ProceedingJoinPoint pjp, Trans ta) throws Throwable {
        try {
            TransactionManager.startTran();
            Object retObj = pjp.proceed();
            TransactionManager.commitTran();
            return retObj;
        } catch (Throwable e) {
            TransactionManager.rollbackTran();
            e.printStackTrace();
            throw e;
        } finally {
            TransactionManager.release();
        }
    }
}
