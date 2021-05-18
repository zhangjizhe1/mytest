package cn.tedu.text;

import cn.tedu.domain.NetConn;
import cn.tedu.domain.NetConnInstanceFactory;
import cn.tedu.domain.NetConnStaticFactory;
import org.junit.Test;

public class app {
    /**
     * 实例工厂方式创建nc
     */
    @Test
    public void test03(){
        NetConnInstanceFactory factory = new NetConnInstanceFactory();
        NetConn nc = factory.getInstance();
        nc.sendData();
    }
    /**
     * 静态工厂方式创建 nc
     */
    @Test
    public void test02(){
        NetConn nc = NetConnStaticFactory.getInstance();
        nc.sendData();
    }

    /**
     * 普通方式创建nc
     */
    @Test
    public void test01(){
        NetConn nc = new NetConn();
        nc.load();
        nc.ping();
        nc.conn();

        nc.sendData();
    }
}
