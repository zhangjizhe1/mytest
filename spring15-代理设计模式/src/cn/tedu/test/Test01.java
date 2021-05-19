package cn.tedu.test;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Star{
    public void eat();
    public void sign();
}

class FBB implements Star{
    public void eat(){
        System.out.println("FBB吃..");
    }

    public void sign(){
        System.out.println("FBB签名..");
    }

    public void shufa(){
        System.out.println("FBB写书法..");
    }
}

public class Test01 {

    /**
     * 代理设计模式 - 动态代理 - Cglib动态代理
     *      解决了代码混杂的问题
     *      解决了代码重复的问题
     *      基于继承实现，对于非接口方法同样可以实现代理
     *
     *      是第三方动态代理，需要导入相关开发包才可以使用
     *      相对于java动态代理效率低一些
     */
    @Test
    public void test04(){
        //被代理者
        FBB fbb = new FBB();

        //代理者
        //--创建增强器
        Enhancer enhancer = new Enhancer();
        //--指定要实现的接口们,非强制
        enhancer.setInterfaces(fbb.getClass().getInterfaces());
        //--指定要继承的父类，强制
        enhancer.setSuperclass(fbb.getClass());
        //--指定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param proxy 代理者，小胖
             * @param method 当前正在被调用的方法
             * @param args 当前正在备调用方法的参数
             * @param mp 方法代理对象
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
                System.out.println("XP:你谁啊？？？？？？");
                Object retObj = method.invoke(fbb, args);
                System.out.println("XP:记录一下");
                return retObj;
            }
        });
        //--生产代理者
        FBB xp = (FBB) enhancer.create();

        //有事不能做找被代理者，要找代理者
        xp.eat();
        xp.sign();
        xp.shufa();
    }

    /**
     * 代理设计模式 - 动态代理 - Java动态代理
     *      解决了代码混杂的问题
     *      解决了代码重复的问题
     *      java动态代理是基于接口实现的，对于非接口方法无法实现代理
     */
    @Test
    public void test03(){
        //被代理者
        FBB fbb = new FBB();

        //代理者
        Star zqd = (Star)Proxy.newProxyInstance(
                fbb.getClass().getClassLoader(),//类加载器
                fbb.getClass().getInterfaces(),//要实现的接口们
                new InvocationHandler() {//处理器
                    /**
                     * @param proxy 代理者
                     * @param method 代表当前正在调用的方法的对象
                     * @param args 代表当前正在调用的方法的参数数组
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("ZQD:你谁啊？？？？？");
                        Object retObj = method.invoke(fbb, args);
                        System.out.println("ZQD:记录日志...");
                        return retObj;
                    }
                }
        );

        //有事不能找被代理者，必须找代理者
        zqd.eat();
        zqd.sign();
        //zqd.shufa();
    }

    /**
     * 代理设计模式 - 静态代理
     *      解决了代码混杂的问题
     *      无法解决代码重复的问题
     */
    @Test
    public void test02(){
        //被代理者
        FBB fbb = new FBB();

        //代理者
        class ZL implements Star{
            @Override
            public void eat() {
                System.out.println("ZL:你谁啊？？？？？");
                fbb.eat();
                System.out.println("ZL:记录一下...");
            }
            @Override
            public void sign() {
                System.out.println("ZL:你谁啊？？？？？");
                fbb.sign();
                System.out.println("ZL:记录一下...");
            }
        }

        //有事不能直接找被代理者，必须通过代理者调用
        ZL zl = new ZL();
        zl.eat();
        zl.sign();
    }

    /**
     * 直接调用方法
     */
    @Test
    public void test01(){
        FBB fbb = new FBB();
        fbb.eat();
        fbb.sign();
    }

}
