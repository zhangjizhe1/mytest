package cn.tedu.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Lazy 懒加载
 */
@Lazy
@Component
public class Person2 {
    public Person2() {
        System.out.println("#Person2..init.." + this);
    }
}
