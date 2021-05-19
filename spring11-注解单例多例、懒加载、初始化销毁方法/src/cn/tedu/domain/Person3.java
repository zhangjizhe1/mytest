package cn.tedu.domain;

import org.springframework.stereotype.Component;

/**
 * 四个注解功能是一模一样的，都是用来将类注册为Spring管理的bean的注解
 * 官方建议在不同的位置使用不同的注解
 *
 * @Controller -- Web层
 * @Service -- Service层
 * @Repository -- Dao层
 * @Component -- 其他位置
 */
@Component
public class Person3 {
}
