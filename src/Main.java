import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо розмір масиву
        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();

        double[] array = new double[n];

        // Зчитуємо елементи масиву
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        // Обчислюємо суму елементів, номери яких збігаються зі значеннями елементів послідовності
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == array[i]) {
                sum += array[i];
            }
        }
        System.out.println("Сума елементів, номери яких збігаються зі значеннями елементів послідовності: " + sum);

        // Обчислюємо кількість елементів масиву, відмінних від значення останнього елемента
        double lastElement = array[n - 1];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] != lastElement) {
                count++;
            }
        }
        System.out.println("Кількість елементів масиву, відмінних від значення останнього елемента: " + count);

        // Змінюємо масив за вказаним правилом
        for (int i = 1; i < n; i++) {
            double max = array[0];
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, array[j]);
            }
            array[i] = max;
        }

        // Виводимо змінений масив
        System.out.println("Змінений масив:");
        for (double element : array) {
            System.out.print(element + " ");
        }
    }
}