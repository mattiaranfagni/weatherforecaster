package it.ranftesting.weatherforecaster.mapper;

import it.ranftesting.weatherforecaster.dto.openmeteo.OpenMeteoDTO;
import it.ranftesting.weatherforecaster.entity.OpenMeteoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OpenMeteoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "elevation", source = "elevation")
    // current weather
    @Mapping(target = "time", source = "currentWeatherDTO.time")
    @Mapping(target = "interval", source = "currentWeatherDTO.interval")
    @Mapping(target = "temperature", source = "currentWeatherDTO.temperature")
    @Mapping(target = "windSpeed", source = "currentWeatherDTO.windSpeed")
    @Mapping(target = "windDirection", source = "currentWeatherDTO.windDirection")
    @Mapping(target = "day", source = "currentWeatherDTO.day")
    @Mapping(target = "weatherCode", source = "currentWeatherDTO.weatherCode")
    // units
    @Mapping(target = "timeUnit", source = "currentWeatherUnitsDTO.time")
    @Mapping(target = "intervalUnit", source = "currentWeatherUnitsDTO.interval")
    @Mapping(target = "temperatureUnit", source = "currentWeatherUnitsDTO.temperature")
    @Mapping(target = "windSpeedUnit", source = "currentWeatherUnitsDTO.windSpeed")
    @Mapping(target = "windDirectionUnit", source = "currentWeatherUnitsDTO.windDirection")
    @Mapping(target = "generationTimestamp", expression = "java(new java.util.Date())")
    OpenMeteoEntity toEntity(OpenMeteoDTO dto);
}