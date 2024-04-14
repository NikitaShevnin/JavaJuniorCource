package Sem3.hw;

import java.io.*;

/**
 * TODO 1. Создайте объект класса Student и инициализируйте его данными.
 * TODO 2. Сериализуйте этот объект в файл.
 * TODO 3. Десериализуйте объект обратно в программу из файла.
 */

public class SerializationDemo {
    public static void main(String[] args) {
        // Создание объекта Student
        Student student = new Student("Alice", 20, 3.5);

        // Сериализация объекта в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(student);
            System.out.println("Объект успешно сериализован в файл 'student.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта из файла
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Объект успешно десериализован из файла 'student.ser'");
            System.out.println("Имя: " + deserializedStudent.getName());
            System.out.println("Возраст: " + deserializedStudent.getAge());
            // Поле GPA не будет восстановлено после десериализации
            System.out.println("GPA: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
