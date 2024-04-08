package Sem2;

import java.lang.reflect.Method;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 3, "Labrador");
        animals[1] = new Cat("Whiskers", 5, 9);
        animals[2] = new Dog("Max", 2, "German Shepherd");

        for (Animal animal : animals) {
            System.out.println("Name: " + animal.name);
            System.out.println("Age: " + animal.age);

            Class<?> animalClass = animal.getClass();
            Method makeSoundMethod;

            try {
                makeSoundMethod = animalClass.getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (Exception e) {
                System.out.println("The makeSound() method is not present in the " + animalClass.getSimpleName() + " class.");
            }

            System.out.println();
        }
    }
}