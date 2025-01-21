package dev.memocode.temphouse.controller;

import dev.memocode.temphouse.DS18B20.service.DS18B20Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final DS18B20Service ds18B20Service;

    @GetMapping("/")
    public String home(Model model) throws IOException {
        Double temperature = ds18B20Service.getTemperature();

        model.addAttribute("temperature", temperature);
        return "home";
    }
}
