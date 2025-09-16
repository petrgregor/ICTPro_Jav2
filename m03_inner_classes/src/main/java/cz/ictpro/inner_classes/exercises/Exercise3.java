package cz.ictpro.inner_classes.exercises;

public class Exercise3 {
    public static void main(String[] args) {
        Car car = new Car("VW", "sport");
        System.out.println(car);
    }
}
class Car {
    private String name;
    private String type;
    private Engine engine;
    public Car(String name, String type) {
        this.name = name;
        this.type = type;
        engine = new Car.Engine();
        engine.setEngineType(type);
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
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", engine=" + engine +
                '}';
    }
    class Engine {
        private String engineType;
        public void setEngineType(String carType) {
            switch (carType) {
                case "economy":
                    engineType = "diesel";
                    break;
                case "luxury":
                    engineType = "electric";
                    break;
                default:
                    engineType = "petrol";
            }
        }
        @Override
        public String toString() {
            return "Engine{" +
                    "engineType='" + engineType + '\'' +
                    '}';
        }
    }
}
