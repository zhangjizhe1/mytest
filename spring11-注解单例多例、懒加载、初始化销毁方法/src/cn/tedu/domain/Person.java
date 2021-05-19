package cn.tedu.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Scope 单例/多例
 */
@Scope("prototype")
@Component
public class Person {
    public Person() {
        System.out.println("#Person..init.." + this);
    }
}
