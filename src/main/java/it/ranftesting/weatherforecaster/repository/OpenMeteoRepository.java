package it.ranftesting.weatherforecaster.repository;

import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenMeteoRepository extends JpaRepository<OpenMeteoEntity, Long> {
}
