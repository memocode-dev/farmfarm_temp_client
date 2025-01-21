package dev.memocode.temphouse.DS18B20.repository.impl;

import dev.memocode.temphouse.DS18B20.repository.DS18B20Reader;
import dev.memocode.temphouse.DS18B20.repository.TemperatureUtils;
import org.springframework.stereotype.Repository;

@Repository
public class FakeDS18B20Reader implements DS18B20Reader {

    private Double lastTemperature = null;

    @Override
    public Double getTemperature() {
        lastTemperature = TemperatureUtils.getFakeTemperature(lastTemperature);
        return lastTemperature;
    }
}
