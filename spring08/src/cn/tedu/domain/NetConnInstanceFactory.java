package cn.tedu.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component //<bean id="netConnInstanceFactory" class="cn.tedu.domain.NetConnInstanceFactory"/>
public class NetConnInstanceFactory {
    @Bean("nc")//<bean id="nc" factory-bean="netConnInstanceFactory" factory-method="getInstance"/>
    public NetConn getInstance(){
        NetConn nc = new NetConn();
        nc.load();
        nc.ping();
        nc.conn();
        return nc;
    }
}
