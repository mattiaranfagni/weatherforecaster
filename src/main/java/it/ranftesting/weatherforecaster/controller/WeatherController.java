package it.ranftesting.weatherforecaster.controller;

import it.ranftesting.weatherforecaster.service.OpenMeteoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class WeatherController {

    private final OpenMeteoService openMeteoService;

    public WeatherController(OpenMeteoService openMeteoService) {
        this.openMeteoService = openMeteoService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to WeatherForecaster!";
    }

    @GetMapping("/openmeteo-api-params")
    public String getOpenMeteoData(@RequestParam("latitude") Float latitude,
                                   @RequestParam("longitude") Float longitude,
                                   @RequestParam("current_weather") Boolean currentWeather) {
        return this.openMeteoService.getOpenMeteoData(latitude, longitude, currentWeather);
    }
}
