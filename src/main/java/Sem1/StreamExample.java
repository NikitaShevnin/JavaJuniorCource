package Sem1;

import java.util.Arrays;
import java.util.List;

/**
 * 1.   Напишите программу, которая использует Stream API для обработки списка чисел.
 *      Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double average = numbers.stream()
                .filter(number -> number % 2 == 0) // отфильтровываем только четные числа
                .mapToInt(Integer::intValue) // преобразуем поток в числовой поток
                .average() // вычисляем среднее значение
                .orElse(0); // если поток пуст, возвращаем 0

        System.out.println("Среднее значение четных чисел: " + average);
    }
}
