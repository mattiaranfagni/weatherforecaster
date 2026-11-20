package it.ranftesting.weatherforecaster.service;

import it.ranftesting.weatherforecaster.dto.OpenMeteoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeatherService {
    @Value("${openmeteo.api.url}")
    private String apiUrl;

    public String getOpenMeteoData(Float latitude, Float longitude, Boolean currentWeather) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = this.apiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current_weather=" + currentWeather;
        OpenMeteoDTO result = restTemplate.getForObject(apiUrl, OpenMeteoDTO.class);
        return Objects.requireNonNull(result).toString();
    }
}
