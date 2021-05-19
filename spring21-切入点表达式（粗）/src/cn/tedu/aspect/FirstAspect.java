package cn.tedu.aspect;

import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
    public void myBefore(){
        System.out.println("#before..");
    }
}
