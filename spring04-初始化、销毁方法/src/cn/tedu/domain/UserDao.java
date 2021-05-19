package cn.tedu.domain;

public class UserDao {

    public void myInit(){
        System.out.println("#连接数据库..");
    }

    public void myDestory(){
        System.out.println("#断开数据库..");
    }

    public void insert(){
        System.out.println("新增..");
    }

    public void delete(){
        System.out.println("删除..");
    }
}
