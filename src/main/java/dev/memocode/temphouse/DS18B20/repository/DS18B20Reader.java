package dev.memocode.temphouse.DS18B20.repository;

import java.io.IOException;

public interface DS18B20Reader {
    Double getTemperature() throws IOException;
}
