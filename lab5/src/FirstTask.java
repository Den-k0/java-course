import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    public static void main(String[] args) {
        String filePath = "/Users/user1/Documents/Навчання/Java (Програмування мовою Java)/Лабораторна робота №5/your_file.txt"; // Шлях до мого файлу

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\"([^\"]+)\""); // Регулярний вираз для пошуку рядків в лапках
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Виводимо знайдені цитати на екран
                    System.out.println(matcher.group(1)); // group(1) поверне тільки текст цитати без лапок
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }
    }
}