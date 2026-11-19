package it.ranftesting.weatherforecaster.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class WeatherService {
    @Value("${openmeteo.api.url}")
    private String apiUrl;

    public String getOpenMeteoData() {
        final String uri = "https://api.myrestservice.com/users";
        RestTemplate restTemplate = new RestTemplate();
        Users result = restTemplate.getForObject(this.apiUrl, Users.class);
        System.out.println(result);
    }
}
