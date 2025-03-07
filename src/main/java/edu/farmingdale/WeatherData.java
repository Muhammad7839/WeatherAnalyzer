package edu.farmingdale;

/**
 * Record representing weather data for a single day.
 */
public record WeatherData(String date, double temperature, double humidity, double precipitation) {

    /**
     * Extracts the month from the date string (format: yyyy-MM-dd).
     *
     * <p>Example Usage:
     * ```java
     * String month = weatherData.getMonth();
     * System.out.println("Month: " + month);
     * ```
     *
     * @return The month as a two-digit string (e.g., "08" for August).
     */
    public String getMonth() {
        return date.substring(5, 7);
    }

    /**
     * Checks if the day is classified as "hot" (temperature > 30°C).
     *
     * <p>Example Usage:
     * ```java
     * boolean isHot = weatherData.isHot();
     * System.out.println("Is hot? " + isHot);
     * ```
     *
     * @return true if the temperature is greater than 30°C, otherwise false.
     */
    public boolean isHot() {
        return temperature > 30;
    }

    /**
     * Checks if the day is considered "rainy" (precipitation > 0mm).
     *
     * <p>Example Usage:
     * ```java
     * boolean isRainy = weatherData.isRainy();
     * System.out.println("Is rainy? " + isRainy);
     * ```
     *
     * @return true if precipitation is greater than 0mm, otherwise false.
     */
    public boolean isRainy() {
        return precipitation > 0;
    }
}
