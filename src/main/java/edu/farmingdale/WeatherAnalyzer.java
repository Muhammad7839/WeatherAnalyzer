package edu.farmingdale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Interface defining weather data analysis methods.
 * Provides static methods for parsing weather data and performing analytical operations.
 */
public interface WeatherAnalyzer {
    /**
     * Parses weather data from a CSV file.
     *
     * @param filename path to CSV file
     * @return list of parsed WeatherData records
     * @throws IOException if file cannot be read
     */
    static List<WeatherData> parseWeatherData(String filename) throws IOException {
        return Files.lines(Path.of(filename))
                .skip(1) // Skip header row
                .map(line -> line.split(","))
                .map(parts -> new WeatherData(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                ))
                .collect(Collectors.toList());
    }

    /**
     * Calculates the average temperature for a specific month.
     *
     * @param data  list of weather data records
     * @param month target month in MM format (01-12)
     * @return average temperature for the specified month
     */
    static double calculateAverageTemp(List<WeatherData> data, String month) {
        return data.stream()
                .filter(w -> w.getMonth().equals(month))
                .mapToDouble(WeatherData::temperature)
                .average()
                .orElse(Double.NaN);
    }

    /**
     * Counts the number of days where the temperature exceeds a given threshold.
     *
     * @param data      list of weather data records
     * @param threshold temperature threshold in Celsius
     * @return number of days exceeding the threshold
     */
    static long countHotDays(List<WeatherData> data, double threshold) {
        return data.stream()
                .filter(w -> w.temperature() > threshold)
                .count();
    }

    /**
     * Counts the number of rainy days (precipitation > 0).
     *
     * @param data list of weather data records
     * @return number of rainy days
     */
    static long countRainyDays(List<WeatherData> data) {
        return data.stream()
                .filter(w -> w.precipitation() > 0)
                .count();
    }

    /**
     * Handles user input to calculate the average temperature for a selected month.
     *
     * @param data    list of weather data records
     * @param scanner Scanner object for user input
     */
    static void handleAverageTemp(List<WeatherData> data, Scanner scanner) {
        String month;
        while (true) {
            System.out.print("Enter month (MM): ");
            month = scanner.next();
            if (month.matches("^(0[1-9]|1[0-2])$")) break;
            System.out.println("❌ Invalid month! Please enter MM format (01-12).\n");
        }
        double avg = calculateAverageTemp(data, month);
        WeatherCategory category = getWeatherCategory(avg);
        System.out.printf("Average temp for %s: %.2f°C (%s)%n", month, avg, category.getLabel());
    }

    /**
     * Handles user input to count the number of days above a temperature threshold.
     *
     * @param data    list of weather data records
     * @param scanner Scanner object for user input
     */
    static void handleDaysAboveThreshold(List<WeatherData> data, Scanner scanner) {
        System.out.print("Enter temperature threshold: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("❌ Invalid input! Enter a number.");
            scanner.next();
        }
        double threshold = scanner.nextDouble();
        long count = countHotDays(data, threshold);
        System.out.printf("Days above %.1f°C: %d%n", threshold, count);
    }

    /**
     * Handles user input to count the number of rainy days.
     *
     * @param data list of weather data records
     */
    static void handleRainyDays(List<WeatherData> data) {
        long rainyDays = countRainyDays(data);
        System.out.println("Rainy days: " + rainyDays);
    }

    /**
     * Determines the weather category based on the given temperature.
     *
     * @param temperature temperature value in Celsius
     * @return WeatherCategory enum representing the category
     */
    static WeatherCategory getWeatherCategory(double temperature) {
        return WeatherCategory.fromTemperature(temperature);
    }
}