package it.ranftesting.weatherforecaster.configuration;

import it.ranftesting.weatherforecaster.entity.CityEntity;
import it.ranftesting.weatherforecaster.repository.CityRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CityInitializer implements CommandLineRunner {

    private final CityRepository cityRepository;

    public CityInitializer(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String @NonNull ... args) {
        addIfMissing("Pistoia", 43.9333f, 10.9167f);
        addIfMissing("Firenze", 43.7696f, 11.2558f);
        addIfMissing("Roma", 41.9028f, 12.4964f);
        addIfMissing("Milano", 45.4642f, 9.19f);
        addIfMissing("Napoli", 40.8518f, 14.2681f);
    }

    private void addIfMissing(String name, Float latitude, Float longitude) {
        if (cityRepository.findByNameIgnoreCase(name).isEmpty()) {
            CityEntity city = new CityEntity();
            city.setName(name);
            city.setLatitude(latitude);
            city.setLongitude(longitude);
            cityRepository.save(city);
        }
    }
}