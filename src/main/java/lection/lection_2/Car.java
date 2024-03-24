package lection.lection_2;

public class Car {
   public String name;
    public String price;
   public String engType;
   public String engPower;
    int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "100000000";
        this.engType = "v8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
