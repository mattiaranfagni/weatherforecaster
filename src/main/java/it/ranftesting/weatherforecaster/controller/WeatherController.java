package it.ranftesting.weatherforecaster.controller;

import it.ranftesting.weatherforecaster.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index() {
        return "Welcome to WeatherForecaster!";
    }

    @GetMapping("/openmeteo-api")
    public String getOpenMeteoData() {

        return "Done";
    }


}
