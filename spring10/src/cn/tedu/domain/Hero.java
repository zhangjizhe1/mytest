package cn.tedu.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *  @Autowired 实现自动装配
 *      首先按照类型进行匹配，
 *          如果找到唯一的bean就注入，
 *          如果找不到或找到多个，则开始按照id匹配
 *      根据id进行匹配(默认用属性名作为查找的id)，
 *          如果找到唯一的就注入，
 *          如果找不到，则抛出异常
 *  @Qualifier
 *      配合@Autowired使用，一旦同时配置了@Qulifier，则注入时不再按照类型注入，直接按照id注入
 *      根据id找到唯一的bean就注入，找不到抛出异常
 */

@Component
public class Hero {

    @Autowired
    @Qualifier("dog")
    private Dog dog;

    @Autowired
    @Qualifier("HSQDog")
    private Dog dog1;

    @Override
    public String toString() {
        return "Hero{" +
                "dog=" + dog +
                "dog=" + dog1 +
                '}';
    }
}
