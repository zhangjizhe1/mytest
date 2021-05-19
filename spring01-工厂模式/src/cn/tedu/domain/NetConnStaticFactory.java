package cn.tedu.domain;

/**
 * 静态工厂
 */
public class NetConnStaticFactory {
    private NetConnStaticFactory(){}
    
    public static NetConn getInstance(){
        NetConn nc = new NetConn();
        nc.load();
        nc.ping();
        nc.conn();
        return nc;
    }
}
