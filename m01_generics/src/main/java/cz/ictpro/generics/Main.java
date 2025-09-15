package cz.ictpro.generics;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(10);
        System.out.println(box.getItem());
        box.setItem("Hello");
        System.out.println(box.getItem());
    }

}

