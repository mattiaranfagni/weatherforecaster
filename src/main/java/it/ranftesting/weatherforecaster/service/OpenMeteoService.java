package it.ranftesting.weatherforecaster.service;

import it.ranftesting.weatherforecaster.dto.OpenMeteoDTO;
import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import it.ranftesting.weatherforecaster.mapper.OpenMeteoMapper;
import it.ranftesting.weatherforecaster.repository.OpenMeteoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class OpenMeteoService {
    @Value("${openmeteo.api.url}")
    private String apiUrl;
    private final OpenMeteoMapper mapper;
    private final OpenMeteoRepository repository;

    public OpenMeteoService(OpenMeteoMapper mapper, OpenMeteoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public String getOpenMeteoData(Float latitude, Float longitude, Boolean currentWeather) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = this.apiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current_weather=" + currentWeather;
        OpenMeteoDTO response = restTemplate.getForObject(apiUrl, OpenMeteoDTO.class);
        if (response == null) {
            throw new IllegalStateException(
                    "Open-Meteo returned an empty response"
            );
        }

        OpenMeteoEntity entity = mapper.toEntity(response);
        repository.save(entity);
        return Objects.requireNonNull(response).toString();
    }
}
