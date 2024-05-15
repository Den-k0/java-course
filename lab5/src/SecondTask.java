import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecondTask {
    public static void main(String[] args) {
        String filePath = "/Users/user1/Documents/Навчання/Java (Програмування мовою Java)/Лабораторна робота №5/products.txt"; // Шлях до вашого файлу

        // Створюємо мапу для зберігання країн-імпортерів для кожного товару
        Map<String, Set<String>> importersMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Розділяємо рядок на частини

                String productName = parts[0].trim();
                String importingCountry = parts[1].trim();

                // Перевіряємо, чи вже є такий товар у мапі
                if (!importersMap.containsKey(productName)) {
                    importersMap.put(productName, new HashSet<>());
                }

                // Додаємо країну-імпортера до списку країн для даного товару
                importersMap.get(productName).add(importingCountry);
            }
        } catch (IOException e) {
            System.err.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }

        // Виводимо країни-імпортери для певного товару
        String product = "Product1"; // Певний товар, для якого шукаємо країни-імпортери
        if (importersMap.containsKey(product)) {
            System.out.println("Країни, які імпортують товар " + product + ":");
            for (String country : importersMap.get(product)) {
                System.out.println(country);
            }
        } else {
            System.out.println("Товар " + product + " не знайдено.");
        }
    }
}
