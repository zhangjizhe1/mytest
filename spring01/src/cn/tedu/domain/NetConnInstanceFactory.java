package cn.tedu.domain;

/**
 * 实例工厂
 */
public class NetConnInstanceFactory {
    public NetConn getInstance(){
        NetConn nc = new NetConn();
        nc.load();
        nc.ping();
        nc.conn();
        return nc;
    }
}
