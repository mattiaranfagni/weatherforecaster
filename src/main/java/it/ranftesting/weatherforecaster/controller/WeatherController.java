package it.ranftesting.weatherforecaster.controller;

import it.ranftesting.weatherforecaster.dto.cityaveragemeasures.CityAveragesDTO;
import it.ranftesting.weatherforecaster.service.OpenMeteoAverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final OpenMeteoAverageService averageService;

    public WeatherController(OpenMeteoAverageService averageService) {
        this.averageService = averageService;
    }

    @GetMapping("/")
    public String  getBaseWelcomeResponse() { return "Welcome to WeatherForecaster!"; }

    @GetMapping("/averages")
    public List<CityAveragesDTO> getAllAverages() {
        return averageService.getAllAverages();
    }

    @GetMapping("/averages/{city}")
    public CityAveragesDTO getAveragesByCity(@PathVariable String city) {
        return averageService.getAveragesByCity(city);
    }
}