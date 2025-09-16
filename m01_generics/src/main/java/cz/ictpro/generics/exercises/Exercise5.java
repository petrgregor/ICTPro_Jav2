package cz.ictpro.generics.exercises;

/*
Task 5
Create a class that will behave like a pet house for the following animals:
- cat
- dog
Please provide a solution for generic types. For data collection, use any array or
Collection API class.
 */

import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args) {
        Animal[] animal = {new Cat("Persian", 10),
                new Dog("German Shepherd", "beef")};
        AnimalHouse<Animal> animals = new AnimalHouse<>(animal);
        System.out.println(Arrays.toString(animals.getAnimals()));
    }
}

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    private String favoriteFood;

    public Dog(String name, String favoriteFood) {
        super(name);
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}

class Cat extends Animal {
    private int numberOfLife;

    public Cat(String name, int numberOfLife) {
        super(name);
        this.numberOfLife = numberOfLife;
    }

    public int getNumberOfLife() {
        return numberOfLife;
    }

    public void setNumberOfLife(int numberOfLife) {
        this.numberOfLife = numberOfLife;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", numberOfLife=" + numberOfLife +
                '}';
    }
}

class AnimalHouse<T extends Animal> {
    T[] animals;

    public AnimalHouse(T[] animals) {
        this.animals = animals;
    }

    public T[] getAnimals() {
        return animals;
    }

    public void setAnimals(T[] animals) {
        this.animals = animals;
    }
}