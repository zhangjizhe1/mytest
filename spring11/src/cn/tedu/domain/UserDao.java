package cn.tedu.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct 配置初始化方法
 * @PreDestroy 配置销毁方法
 */
@Component //<bean id="userDao" class="cn.tedu.domain.UserDao" init-method="myInit" destory-method="myDestory"/>
public class UserDao {

    @PostConstruct
    public void myInit() {
        System.out.println("#创建连接..");
    }

    @PreDestroy
    public void myDestory() {
        System.out.println("#断开连接..");
    }

    public void insert() {
        System.out.println("新增..");
    }

    public void delete() {
        System.out.println("删除..");
    }
}
