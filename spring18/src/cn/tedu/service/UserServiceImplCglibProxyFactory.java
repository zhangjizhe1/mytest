package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class UserServiceImplCglibProxyFactory {

    @Autowired
    private UserServiceImpl userServiceImpl = null;

    @Bean("userService")
    public UserService getProxy(){
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.指定要实现的接口们，非强制
        enhancer.setInterfaces(userServiceImpl.getClass().getInterfaces());
        //3.指定要继承的父类,强制
        enhancer.setSuperclass(userServiceImpl.getClass());
        //4.设定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
                try {
                    System.out.println("#记录日志..");
                    System.out.println("#控制权限..");
                    System.out.println("#开启事务..");
                    Object retObj = method.invoke(userServiceImpl, args);
                    System.out.println("#提交事务..");
                    return retObj;
                }catch (Exception e){
                    System.out.println("#回滚事务..");
                    e.printStackTrace();
                    throw e;
                }
            }
        });
        //5.生产代理者
        UserService proxy = (UserService) enhancer.create();

        return proxy;
    }
}
