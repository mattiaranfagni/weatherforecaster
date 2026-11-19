package it.ranftesting.weatherforecaster.controller;

import it.ranftesting.weatherforecaster.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to WeatherForecaster!";
    }

    @GetMapping("/openmeteo-api")
    public String getOpenMeteoData(@RequestParam("latitude") Float latitude,
                                   @RequestParam("longitude") Float longitude,
                                   @RequestParam("current_weather") Boolean currentWeather) {
        return this.weatherService.getOpenMeteoData(latitude, longitude, currentWeather);
    }


}
