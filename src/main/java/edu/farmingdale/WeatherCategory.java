package edu.farmingdale;

/**
 * Enum representing different weather categories based on temperature.
 */
public enum WeatherCategory {
    HOT("🔥 Hot"),
    WARM("☀️ Warm"),
    COLD("❄️ Cold");

    private final String label;

    /**
     * Constructor to assign a label to each weather category.
     *
     * @param label The emoji and text representing the category.
     */
    WeatherCategory(String label) {
        this.label = label;
    }

    /**
     * Retrieves the label of the weather category.
     *
     * @return The label associated with the category.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Determines the weather category based on temperature.
     *
     * @param temperature The temperature value in Celsius.
     * @return The corresponding WeatherCategory based on the given temperature.
     */
    public static WeatherCategory fromTemperature(double temperature) {
        return switch ((int) Math.floor(temperature)) {
            case int t when t >= 30 -> HOT;
            case int t when t >= 20 -> WARM;
            default -> COLD;
        };
    }
}