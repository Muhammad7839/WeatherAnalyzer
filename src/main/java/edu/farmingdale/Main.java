import edu.farmingdale.WeatherAnalyzer;
import edu.farmingdale.WeatherData;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Main entry point for the Weather Data Analyzer application.
 * Reads weather data from a CSV file and provides an interactive menu for analysis.
 */
public class Main {
    /**
     * Loads weather data and starts user interaction.
     *
     * <p>Example Usage:
     * ```java
     * Main.main(new String[]{});
     * ```
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            Path filePath = Path.of("src/main/resources/weatherdata.csv");
            List<WeatherData> data = WeatherAnalyzer.parseWeatherData(filePath.toString());
            interactWithUser(data);
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    /**
     * Displays an interactive menu and processes user choices.
     *
     * <p>Example Usage:
     * ```java
     * interactWithUser(weatherDataList);
     * ```
     *
     * @param data List of WeatherData objects.
     */
    private static void interactWithUser(List<WeatherData> data) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                    ================================
                    Weather Data Analyzer
                    ================================
                    1. Average temperature for a month
                    2. Days above temperature threshold
                    3. Count rainy days
                    4. Exit
                    ================================
                    Enter your choice: 
                """);

                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> WeatherAnalyzer.handleAverageTemp(data, scanner);
                    case 2 -> WeatherAnalyzer.handleDaysAboveThreshold(data, scanner);
                    case 3 -> WeatherAnalyzer.handleRainyDays(data);
                    case 4 -> {
                        System.out.println("🚪 Exiting program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("❌ Invalid option! Please choose 1-4.");
                }
            }
        }
    }
}
