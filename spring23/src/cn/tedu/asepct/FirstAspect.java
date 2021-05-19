package cn.tedu.asepct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class FirstAspect {

    /**
     * 最终通知
     *      在目标方法执行之后执行的通知，无论是正常结束 还是异常结束都会执行
     *      可以获取也可以不获取，但是一旦接收该参数就必须出现在参数列表的第一位
     *      JoinPoint代表当前连接点，通过该对象可以获取目标对象目标方法相关的信息
     *      可以通过配置在异常通知中获取底层抛出的异常信息
     */
    public void myAfter(JoinPoint jp){
        //获取目标对象
        Object target = jp.getTarget();
        Class<?> clz = target.getClass();
        System.out.println(clz);

        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        System.out.println(method);

        System.out.println("#First..after..");
    }

    /**
     * 异常通知
     *      在目标方法抛出异常时执行的通知
     *      以在后置通知的参数列表中选择性的接收一个JoinPoint类型的参数
     *      可以获取也可以不获取，但是一旦接收该参数就必须出现在参数列表的第一位
     *      JoinPoint代表当前连接点，通过该对象可以获取目标对象目标方法相关的信息
     *      可以通过配置在异常通知中获取底层抛出的异常信息
     */
    public void myAfterThrowing(JoinPoint jp,Exception e){
        //获取目标对象
        Object target = jp.getTarget();
        Class<?> clz = target.getClass();
        System.out.println(clz);

        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        System.out.println(method);

        System.out.println("#first..afterThrowing.."+e);
    }


    /**
     * 后置通知
     *      在目标方法成功执行之后执行的通知
     *      可以在后置通知的参数列表中选择性的接收一个JoinPoint类型的参数
     *      可以获取也可以不获取，但是一旦接收该参数就必须出现在参数列表的第一位
     *      JoinPoint代表当前连接点，通过该对象可以获取目标对象目标方法相关的信息
     *      后置通知可以通过配置来获取返回值
     */
    public void myAfterReturning(JoinPoint jp,Object retObj){

        //获取目标对象
        Object target = jp.getTarget();
        Class<?> clz = target.getClass();
        System.out.println(clz);

        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        System.out.println(method);

        System.out.println("#first..afterReturning.."+retObj);
    }


    /**
     * 环绕通知
     *      在目标方法执行之前和之后都要执行的通知
     *      必须在环绕通知中显式调用目标方法，否则目标方法不会执行
     *          可以在环绕通知中接收一个ProceedingJoinPoint类型的参数
     *          可以接收也可以不接收，但是一旦接收必须保证该参数处在参数列表的第一位
     *          ProceedingJoinPoint是JoinPoint类型的子类，同样可以用来获取目标对象 目标方法相关信息
     *          此外，ProceedingJoinPoint提供了调用目标方法的方法
     *          在调用目标方法的代码之前的代码将会在目标方法执行之前执行，在调用目标方法的代码之后的代码将会在目标方法执行之后执行
     *      必须在环绕通知中显式的返回返回值，否则调用者得不到返回值
     *      环绕通知也可以修改返回的返回值，但不建议这样做，容易破坏高内聚 低耦合的原则
     *
     *     环绕通知：
     *          控制目标方法是否执行
     *          在目标方法执行之前和之后执行额外代码
     *          控制调用者是否可以获取到返回值
     *          改变返回值
     *     虽然功能很多，但是要小心，不要破坏高内聚 低耦合的原则
     */
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        //获取目标对象
        Object target = pjp.getTarget();
        Class<?> clz = target.getClass();
        System.out.println(clz);

        //获取目标方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        System.out.println(method);

        System.out.println("#first..around..before..");
        Object retObj = pjp.proceed();
        System.out.println("#first..around..after..");
        return null;
    }

    /**
     * 前置通知
     *      在目标方法执行之前执行的通知
     *      可以在前置通知的参数列表中选择性的接收一个JoinPoint类型的参数
     *      可以获取也可以不获取，但是一旦接收该参数就必须出现在参数列表的第一位
     *      JoinPoint代表当前连接点，通过该对象可以获取目标对象目标方法相关的信息
     */
    public void myBefore(JoinPoint jp){
        //获取目标对象
        Object target = jp.getTarget();
        Class<?> clz = target.getClass();
        System.out.println(clz);

        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        System.out.println(method);

        System.out.println("#first..before..");
    }
}
