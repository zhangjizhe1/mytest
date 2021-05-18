package cn.tedu.domain;


public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(int age) {

    }

    @Override
    public java.lang.String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println("吃");
    }
    public Person(Dog dog){
        System.out.println(dog+ " Person有参构造");
    }
}
