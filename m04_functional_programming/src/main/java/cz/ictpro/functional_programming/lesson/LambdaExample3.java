package cz.ictpro.functional_programming.lesson;

public class LambdaExample3 {
    public static void main(String[] args) {

        FruitEater<String> fruitEater = fruit -> System.out.println(String.format("eating %s... omnomnom", fruit));

        fruitEater.consume("Apple");

    }

    @FunctionalInterface
    public interface FruitEater<T> {
        void consume(T t);
    }

}
