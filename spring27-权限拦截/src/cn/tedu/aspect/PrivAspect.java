package cn.tedu.aspect;

import cn.tedu.anno.PrivAnno;
import cn.tedu.enums.Role;
import cn.tedu.web.UserServlet;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class PrivAspect {

    @Around("execution(* cn.tedu.service..*(..)) && @annotation(pa)")
    public Object around(ProceedingJoinPoint pjp, PrivAnno pa) throws Throwable {
        //获取当前用户角色
        Role role = UserServlet.role;
        //获取当前方法需要的角色
        Role[] roles = pa.value();
        //检查是否匹配
        if(Arrays.asList(roles).contains(role)){
            //匹配，放行
            return pjp.proceed();
        }else{
            //不匹配，抛异常
            throw new RuntimeException("权限不足 无法访问");
        }
    }

    /*
    @Around("execution(* cn.tedu.service..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取目标对象
        Object target = pjp.getTarget();
        Class<?> clz = target.getClass();
        //获取目标方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method intf_method = signature.getMethod();
        Method inst_method = clz.getMethod(intf_method.getName(), intf_method.getParameterTypes());

        //判断当前方法上是否有@PrivAnno
        if(inst_method.isAnnotationPresent(PrivAnno.class)){
            //有，需要权限，检查
            //-获取当前用户角色
            Role role = UserServlet.role;
            //-获取当前方法需要的角色
            PrivAnno panno = inst_method.getAnnotation(PrivAnno.class);
            Role[] roles = panno.value();
            //-检查是否匹配
            if(Arrays.asList(roles).contains(role)){
                //--匹配，放行
                return pjp.proceed();
            }else{
                //--不匹配，抛异常
                throw new RuntimeException("权限不足 无法访问！");
            }
        }else{
            //没有，不需要权限，放行
            return pjp.proceed();
        }
    }
    */
}
