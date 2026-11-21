
package it.ranftesting.weatherforecaster.service;

import it.ranftesting.weatherforecaster.dto.openmeteo.OpenMeteoDTO;
import it.ranftesting.weatherforecaster.entity.CityEntity;
import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import it.ranftesting.weatherforecaster.mapper.OpenMeteoMapper;
import it.ranftesting.weatherforecaster.repository.CityRepository;
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
    private final CityRepository cityRepository;
    private final RestTemplate restTemplate;

    public OpenMeteoService(OpenMeteoMapper mapper,OpenMeteoRepository repository, CityRepository cityRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.cityRepository = cityRepository;
        this.restTemplate = new RestTemplate();
    }

    public String getOpenMeteoData(String cityName,Float latitude,Float longitude,Boolean currentWeather) {
        String apiUrl = this.apiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current_weather=" + currentWeather;

        OpenMeteoDTO response =
                restTemplate.getForObject(apiUrl, OpenMeteoDTO.class);

        if (response == null) {
            throw new IllegalStateException(
                    "Open-Meteo returned an empty response"
            );
        }

        CityEntity city = cityRepository
                .findByNameIgnoreCase(cityName)
                .orElseGet(() -> {
                    CityEntity newCity = new CityEntity();
                    newCity.setName(cityName);
                    newCity.setLatitude(latitude);
                    newCity.setLongitude(longitude);
                    return cityRepository.save(newCity);
                });

        OpenMeteoEntity entity = mapper.toEntity(response);
        entity.setCity(city);
        repository.save(entity);
        return Objects.requireNonNull(response).toString();
    }
}
