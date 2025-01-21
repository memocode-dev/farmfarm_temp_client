package dev.memocode.temphouse.DS18B20.service;

import dev.memocode.temphouse.DS18B20.repository.DS18B20Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DS18B20Service {

    private final dev.memocode.temphouse.DS18B20.repository.DS18B20Reader DS18B20Reader;

    public Double getTemperature() throws IOException {
        return DS18B20Reader.getTemperature();
    }
}
