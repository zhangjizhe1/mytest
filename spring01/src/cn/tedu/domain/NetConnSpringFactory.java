package cn.tedu.domain;

import org.springframework.beans.factory.FactoryBean;

/**
 * Spring工厂创建bean
 */
public class NetConnSpringFactory implements FactoryBean<NetConn> {

    /**
     *  生产目标对象的方法
     *  spring容器会调用此方法生产目标对象
     */
    @Override
    public NetConn getObject() throws Exception {
        NetConn nc = new NetConn();
        nc.load();
        nc.ping();
        nc.conn();
        return nc;
    }

    /**
     * 获取目标对象类型的方法
     * Spring容器会自动调用此方法了解当前生产的目标对象的类型
     */
    @Override
    public Class<?> getObjectType() {
        return NetConn.class;
    }

    /**
     * 控制生产的目标对象是否是单例的
     * Spring容器会自动调用此方法判断创建的bean是否需要单例
     *
     *  单例/多例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
