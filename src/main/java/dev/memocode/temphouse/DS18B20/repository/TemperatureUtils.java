package dev.memocode.temphouse.DS18B20.repository;

import java.util.Random;

public class TemperatureUtils {

    private static final Random random = new Random();

    public static double getFakeTemperature(Double lastTemperature) {
        if (lastTemperature == null) {
            return -1 + 41 * random.nextDouble();
        } else {
            double change = -2 + random.nextDouble() * 4;
            double temperature = lastTemperature + change;

            if (temperature < -1) {
                temperature = -1.0;
            } else if (temperature > 40) {
                temperature = 40.0;
            }

            return temperature;
        }
    }
}
