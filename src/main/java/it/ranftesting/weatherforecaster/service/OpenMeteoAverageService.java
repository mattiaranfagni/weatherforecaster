package it.ranftesting.weatherforecaster.service;

import it.ranftesting.weatherforecaster.dto.cityaveragemeasures.*;
import it.ranftesting.weatherforecaster.entity.CityEntity;
import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import it.ranftesting.weatherforecaster.repository.CityRepository;
import it.ranftesting.weatherforecaster.repository.OpenMeteoRepository;
import it.ranftesting.weatherforecaster.util.WeatherUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OpenMeteoAverageService {

    private final CityRepository cityRepository;
    private final OpenMeteoRepository repository;

    public OpenMeteoAverageService(CityRepository cityRepository, OpenMeteoRepository repository) {
        this.cityRepository = cityRepository;
        this.repository = repository;
    }

    public List<CityAveragesDTO> getAllAverages() {
        List<CityAveragesDTO> result = new ArrayList<>();
        for (CityEntity city : cityRepository.findAll()) {
            result.add(buildDto(city));
        }
        return result;
    }

    public CityAveragesDTO getAveragesByCity(String cityName) {
        CityEntity city = cityRepository.findByNameIgnoreCase(cityName.trim())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "City '" + cityName + "' not found"));
        return buildDto(city);
    }

    private CityAveragesDTO buildDto(CityEntity city) {
        CityAveragesDTO cityAveragesDTO = new CityAveragesDTO();
        cityAveragesDTO.setCity(city.getName());

        List<OpenMeteoEntity> openMeteoEntities = repository.findByCityId(city.getId());

        // nessuna rilevazione ancora salvata per questa citta'
        if (openMeteoEntities.isEmpty()) {
            cityAveragesDTO.setSamples(0L);
            return cityAveragesDTO;
        }

        double sumTemperature = 0;
        int countTemperature = 0;
        double sumWindSpeed = 0;
        int countWindSpeed = 0;
        List<Integer> windDirections = new ArrayList<>();
        List<String> weatherCodes = new ArrayList<>();
        LocalDateTime first = null;
        LocalDateTime last = null;

        for (OpenMeteoEntity m : openMeteoEntities) {
            if (m.getTemperature() != null) {
                sumTemperature += m.getTemperature();
                countTemperature++;
            }
            if (m.getWindSpeed() != null) {
                sumWindSpeed += m.getWindSpeed();
                countWindSpeed++;
            }
            windDirections.add(m.getWindDirection());
            weatherCodes.add(m.getWeatherCode());

            if (m.getTime() != null) {
                if (first == null || m.getTime().isBefore(first)) {
                    first = m.getTime();
                }
                if (last == null || m.getTime().isAfter(last)) {
                    last = m.getTime();
                }
            }
        }

        // prendo la prima per le unit per semplicità
        OpenMeteoEntity ref = openMeteoEntities.getFirst();

        cityAveragesDTO.setSamples((long) openMeteoEntities.size());
        cityAveragesDTO.setFrom(first);
        cityAveragesDTO.setTo(last);

        if (countTemperature > 0) {
            cityAveragesDTO.setTemperature(new MeasureDTO(
                    WeatherUtil.round(sumTemperature / countTemperature), ref.getTemperatureUnit()));
        }
        if (countWindSpeed > 0) {
            cityAveragesDTO.setWindSpeed(new MeasureDTO(
                    WeatherUtil.round(sumWindSpeed / countWindSpeed), ref.getWindSpeedUnit()));
        }

        Double direction = WeatherUtil.circularMean(windDirections);
        if (direction != null) {
            // hanno null prima di essere salvate
            String unit = ref.getWindDirectionUnit() != null ? ref.getWindDirectionUnit() : "°";
            cityAveragesDTO.setWindDirection(new MeasureDTO(direction, unit));
        }

        cityAveragesDTO.setMostFrequentWeatherCode(WeatherUtil.mostFrequent(weatherCodes));
        return cityAveragesDTO;
    }
}