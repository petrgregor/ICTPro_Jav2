package cz.ictpro.threads.exercises;

public class Exercise2 {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        Car car1 = new Car("VW", "Combi");
        Car car2 = new Car("SEAT", "Suv");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bridge.driveThrough(car1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bridge.driveThrough(car2);
            }
        });
        thread1.start();
        thread2.start();
    }
}
class Car {
    private String name;
    private String type;
    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
class Bridge {
    public synchronized void driveThrough(Car car) {
        System.out.println("Driving through: " + car);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished!: " + car);
    }
}