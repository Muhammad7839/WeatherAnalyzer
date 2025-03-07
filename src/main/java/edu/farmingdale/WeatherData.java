package edu.farmingdale;

/**
 * Record representing weather data for a single day.
 * Stores date, temperature, humidity, and precipitation values.
 */
public record WeatherData(String date, double temperature, double humidity, double precipitation) {

    /**
     * Extracts the month from the date string (format: yyyy-MM-dd).
     *
     * @return The month as a two-digit string (e.g., "08" for August).
     */
    public String getMonth() {
        return date.substring(5, 7);
    }

    /**
     * Determines if the temperature qualifies as a "hot" day.
     *
     * @return {@code true} if the temperature is above 30°C, otherwise {@code false}.
     */
    public boolean isHot() {
        return temperature > 30;
    }

    /**
     * Determines if the day is considered "rainy" based on precipitation.
     *
     * @return {@code true} if precipitation is greater than 0mm, otherwise {@code false}.
     */
    public boolean isRainy() {
        return precipitation > 0;
    }
}