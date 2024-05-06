import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World";

        // Перетворюємо рядок на масив символів
        char[] charArray = str.toCharArray();

        // Сортуємо масив символів
        Arrays.sort(charArray);

        // Створюємо новий рядок з відсортованими літерами
        String sortedStr = new String(charArray);

        // Виводимо відсортований рядок
        System.out.println("Рядок з відсортованими літерами: " + sortedStr);
    }
}