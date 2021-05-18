package cn.tedu.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
    <bean id="hero" class="cn.tedu.domain.Hero">
        <property name=".." value=".."/>
    </bean>
 */
@Component
public class Hero {
    //--基本数据类型、String类型
    //@Value("亚瑟")
    @Value("${name}")
    private String name;
    //@Value("55")
    @Value("${age}")
    private int age;

    //--集合类型、Map类型、Properties类型
    @Value("#{@l1}")
    private List<String> list;
    @Value("#{@s1}")
    private Set<String> set;
    @Value("#{@m1}")
    private Map<String,Object> map;
    @Value("#{@p1}")
    private Properties props;

    //--自定义bean类型

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", props=" + props +
                '}';
    }
}



