package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service
public class UserServiceImplJavaProxyFactory {

    @Autowired
    private UserServiceImpl userServiceImpl = null;

    @Bean("userService")
    public UserService getProxy(){
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userServiceImpl.getClass().getClassLoader(),
                userServiceImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try{
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
        return proxy;
    }
}
