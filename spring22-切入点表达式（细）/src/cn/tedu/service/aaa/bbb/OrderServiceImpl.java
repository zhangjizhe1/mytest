package cn.tedu.service.aaa.bbb;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder() {
        System.out.println("新增订单");
    }

    @Override
    public void queryOrder() {
        System.out.println("查询订单");
    }
}
