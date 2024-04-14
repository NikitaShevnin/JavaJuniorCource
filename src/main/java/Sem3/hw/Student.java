package Sem3.hw;

import java.io.*;

/**
 * TODO Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 */
class Student implements Serializable {
    private String name;
    private int age;

    // Ключевое слово transient указывает на то, что это поле не должно быть сериализовано
    private transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
}
