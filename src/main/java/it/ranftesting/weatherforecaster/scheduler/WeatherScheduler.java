package it.ranftesting.weatherforecaster.scheduler;

import it.ranftesting.weatherforecaster.entity.CityEntity;
import it.ranftesting.weatherforecaster.repository.CityRepository;
import it.ranftesting.weatherforecaster.service.OpenMeteoSamplingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherScheduler {

    private final CityRepository cityRepository;
    private final OpenMeteoSamplingService openMeteoSamplingService;

    public WeatherScheduler(CityRepository cityRepository, OpenMeteoSamplingService openMeteoSamplingService) {
        this.cityRepository = cityRepository;
        this.openMeteoSamplingService = openMeteoSamplingService;
    }

    // default: ogni 15 minuti, prima esecuzione dopo 5 secondi (in ms)
    @Scheduled(fixedDelayString = "${openmeteo.api.polling.interval:900000}",
            initialDelayString = "${openmeteo.api.polling.initial-delay:5000}")
    public void collectWeatherData() {
        for (CityEntity city : cityRepository.findAll()) {
            try {
                openMeteoSamplingService.getOpenMeteoData(city.getName(), city.getLatitude(), city.getLongitude(), true);
            } catch (Exception e) {
                // se una citta fallisce va avanti con le altre
                log.error("Errore nel recupero dei dati meteo per {}: {}", city.getName(), e.getMessage());
            }
        }
    }
}