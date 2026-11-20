package it.ranftesting.weatherforecaster.repository;

import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpenMeteoRepository extends JpaRepository<OpenMeteoEntity, Long> {
    List<OpenMeteoEntity> findByCityId(Long cityId);
}
