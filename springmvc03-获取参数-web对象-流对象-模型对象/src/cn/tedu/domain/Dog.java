package cn.tedu.domain;

public class Dog {
    private String dname;
    private int dage;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDage() {
        return dage;
    }

    public void setDage(int dage) {
        this.dage = dage;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dname='" + dname + '\'' +
                ", dage=" + dage +
                '}';
    }
}
