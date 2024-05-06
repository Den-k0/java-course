import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення текстового рядка
        System.out.print("Введіть текстовий рядок: ");
        String input = scanner.nextLine();

        // Заміна великих літер на малі та виведення на екран
        String lowercaseText = input.toLowerCase();
        System.out.println("Текст замість великих літер на малі: " + lowercaseText);

        // Знаходження найдовшого слова
        String[] words = input.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Найдовше слово: " + longestWord);

        // Видалення слів з непарною кількістю приголосних літер
        String[] vowels = {"a", "e", "i", "o", "u", "а", "е", "є", "и", "і", "ї", "о", "у", "ю", "я"};
        String[] newWords = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : newWords) {
            int consonantCount = 0;
            for (char c : word.toCharArray()) {
                String lowerCaseChar = String.valueOf(Character.toLowerCase(c));
                if (!contains(vowels, lowerCaseChar) && Character.isLetter(c)) {
                    consonantCount++;
                }
            }
            if (consonantCount % 2 == 0) {
                result.append(word).append(" ");
            }
        }
        System.out.println("Текст без слів з непарною кількістю приголосних літер: " + result.toString().trim());
    }

    // Перевірка наявності елемента у масиві
    public static boolean contains(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }
}