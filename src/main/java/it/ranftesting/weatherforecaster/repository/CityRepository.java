package it.ranftesting.weatherforecaster.repository;

import it.ranftesting.weatherforecaster.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    //case insensitive
    Optional<CityEntity> findByNameIgnoreCase(String name);
}
