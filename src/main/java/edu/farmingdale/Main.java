import edu.farmingdale.WeatherAnalyzer;
import edu.farmingdale.WeatherData;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Main entry point for the Weather Data Analyzer application.
 * This program reads weather data from a CSV file and provides interactive menu options
 * for analyzing the data, such as calculating the average temperature, counting hot days,
 * and identifying rainy days.
 */
public class Main {
    /**
     * Main method to initialize the program, load weather data, and start user interaction.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            // Load weather data from the specified CSV file
            Path filePath = Path.of("src/main/resources/weatherdata.csv");
            List<WeatherData> data = WeatherAnalyzer.parseWeatherData(filePath.toString());

            // Start user interaction
            interactWithUser(data);
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    /**
     * Displays an interactive menu for the user and processes selected options.
     * The user can calculate the average temperature for a month, count hot days,
     * count rainy days, or exit the program.
     *
     * @param data List of WeatherData objects parsed from the CSV file.
     */
    private static void interactWithUser(List<WeatherData> data) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                    ================================
                    🌦️  Weather Data Analyzer  🌦️
                    ================================
                    1. Average temperature for a month
                    2. Days above temperature threshold
                    3. Count rainy days
                    4. Exit
                    ================================
                    Enter your choice: 
                """);

                // Validate if user input is an integer
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.next(); // Consume invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> WeatherAnalyzer.handleAverageTemp(data, scanner); // Calculate average temperature
                    case 2 -> WeatherAnalyzer.handleDaysAboveThreshold(data, scanner); // Count hot days
                    case 3 -> WeatherAnalyzer.handleRainyDays(data); // Count rainy days
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
