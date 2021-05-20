package cn.tedu.domain;

public class User2 {
    private String uname;
    private String uage;
    private Dog udog;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage;
    }

    public Dog getUdog() {
        return udog;
    }

    public void setUdog(Dog udog) {
        this.udog = udog;
    }

    @Override
    public String toString() {
        return "User2{" +
                "uname='" + uname + '\'' +
                ", uage='" + uage + '\'' +
                ", udog=" + udog +
                '}';
    }
}
