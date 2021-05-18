package cn.tedu.domain;

public class Second extends Person{
    public void run(){
        System.out.println("跑");
    }

    @Override
    public void eat() {
        System.out.println("子类吃");
    }
}
