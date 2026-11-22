package it.ranftesting.weatherforecaster.configuration;

import it.ranftesting.weatherforecaster.repository.CityRepository;
import it.ranftesting.weatherforecaster.scheduler.IWeatherScheduler;
import it.ranftesting.weatherforecaster.scheduler.OpenMeteoWeatherScheduler;
import it.ranftesting.weatherforecaster.service.OpenMeteoSamplingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class WeatherSchedulerConfiguration {

    @Bean
    @ConditionalOnProperty(name = "weatherforecaster.provider", havingValue = "openmeteo")
    public IWeatherScheduler openMeteoWeatherScheduler(CityRepository cityRepository,
                                                      OpenMeteoSamplingService openMeteoSamplingService) {
        return new OpenMeteoWeatherScheduler(cityRepository, openMeteoSamplingService);
    }
    //se ci fossero altri provider da prendere
}