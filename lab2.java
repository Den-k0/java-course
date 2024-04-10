import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Кількість елементів у масиві
        int arrayLength = 10;

        // Створення масиву для зберігання псевдовипадкових чисел
        double[] randomArray = new double[arrayLength];

        // Генерація псевдовипадкових чисел з рівномірним розподілом
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextDouble(); // генерує числа від 0 до 1
        }

        // Виведення всіх проміжних значень на екран
        System.out.println("Псевдовипадковий масив:");
        System.out.println(Arrays.toString(randomArray));

        // Знаходження мінімального і максимального значень
        double min = randomArray[0];
        double max = randomArray[0];
        for (int i = 1; i < arrayLength; i++) {
            if (randomArray[i] < min) {
                min = randomArray[i];
            }
            if (randomArray[i] > max) {
                max = randomArray[i];
            }
        }

        // Виведення мінімального і максимального значень на екран
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
    }
}