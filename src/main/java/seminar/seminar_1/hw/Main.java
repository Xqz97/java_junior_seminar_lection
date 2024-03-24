package seminar.seminar_1.hw;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayOfNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        OptionalDouble averageOfEvenNum = arrayOfNum.stream()
                .filter(num -> num % 2 == 0) // фильтруем только четные числа
                .mapToInt(Integer::intValue) // преобразуем в int для нахождения среднего значения
                .average(); // находим среднее значение четных чисел

// Проверяем, есть ли что-то в OptionalDouble и выводим результат
        if (averageOfEvenNum.isPresent()) {
            System.out.println("Среднее значение четных чисел: " + averageOfEvenNum.getAsDouble());
        } else {
            System.out.println("Нет четных чисел для нахождения среднего значения.");
        }
    }

}
