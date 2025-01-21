package dev.memocode.temphouse.DS18B20.repository.impl;

import dev.memocode.temphouse.DS18B20.repository.DS18B20Reader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Repository
@Profile("prod")
public class RealDS18B20Reader implements DS18B20Reader {

    private static final String BASE_PATH = "/sys/bus/w1/devices/";

    private static final String TEMPERATURE_FILE = "w1_slave";

    @Value("${custom.DS18B20-1.deviceId}")
    private String DEVICE_FOLDER;

    public Double getTemperature() throws IOException {
        String deviceFolderPath = BASE_PATH + DEVICE_FOLDER;
        String filePath = deviceFolderPath + "/" + TEMPERATURE_FILE;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains("t=")) {
                    String tempStr = line.split("t=")[1];
                    return Double.parseDouble(tempStr) / 1000.0;
                }
            }
        }
        throw new IOException("Temperature data not found in " + filePath);
    }
}
