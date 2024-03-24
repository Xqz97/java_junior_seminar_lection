package lection.lection_1;

public class User {
    String name;
    int age;

    public User(String namge, int age) {
        this.name = namge;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "namge='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
