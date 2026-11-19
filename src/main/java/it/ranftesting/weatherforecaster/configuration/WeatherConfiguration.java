package it.ranftesting.weatherforecaster.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
class WeatherConfiguration {
    @Value("${openmeteo.api.url}")
    private String apiUrl;

    @Bean
    public WeatherController myBeanWithProperties() {
        return new MyBeanWithPropertiesImpl(propertyOne, propertyTwo);
    }

}
