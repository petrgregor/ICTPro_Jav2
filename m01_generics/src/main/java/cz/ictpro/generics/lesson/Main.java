package cz.ictpro.generics.lesson;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*Box box = new Box();

        box.setItem(10);
        System.out.println(box.getItem());

        box.setItem("Hello");
        System.out.println(box.getItem());

        box.setItem(new String[]{"Hello", "world"});
        System.out.println(box.getItem());*/

        Box<Integer> numberBox = new Box<Integer>();
        numberBox.setItem(15);
        System.out.println(numberBox.getItem());

        Box<Integer> numberBox2 = new Box<>();
        numberBox2.setItem(30);
        System.out.println(numberBox2.getItem());

        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());

        Pair<String, Float> pair = new Pair<String, Float>();
        pair.setKey("Hello");
        pair.setValue(13.0F);
        System.out.println(pair);

        Pair<Integer, String> numberPair = new Pair<>();
        numberPair.setKey(10);
        numberPair.setValue("deset");
        System.out.println(numberPair);

        Pair<Integer, String> firstPair = PairGenerator.generatePair(1, "value1");
        System.out.println(firstPair);
        Pair<Long, String> secondPair = PairGenerator.<Long, String>generatePair(2L, "value2");
        System.out.println(secondPair);
        Pair<String, String> thirdPair = PairGenerator.generatePair("Hello", "World");
        System.out.println(thirdPair);

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setValue(3.3);
        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.setValue(10);
        System.out.println(intBox.getValue() + " " + doubleBox.getValue());

        //NumberBox<String> stringBox2 = new NumberBox<String>();
        /*
        * error: type argument String is not within bounds of type-variable T
        NumberBox<String> stringBox2 = new NumberBox<String>();
                  ^
  where T is a type-variable:
    T extends Number declared in class NumberBox
        * */

        //NumberBox<String> stringBox = new NumberBox<String>();

        List<Integer> values = List.of(1, 2, 3);
        System.out.println(UpperBoundedWildcards.sum(values));
        //*/
        //LowerBoundedWildcards.addNumbers(List.of(1, 2, 3));
        //LowerBoundedWildcards.addNumbers(List.of(new Object(), new Object(), new Object()));
    }

}

