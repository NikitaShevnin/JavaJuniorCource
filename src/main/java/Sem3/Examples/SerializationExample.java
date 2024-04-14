package Sem3.Examples;

import java.io.*;
public class SerializationExample {
    public static void main(String[] args) {
        // Создаем объект Person
        Person person = new Person("John", 30);

        // Сериализуем объект в файл
        try {
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Объект успешно сериализован в файл 'person.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализуем объект из файла
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Объект успешно десериализован из файла 'person.ser'");
            System.out.println("Имя: " + deserializedPerson.getName());
            System.out.println("Возраст: " + deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}