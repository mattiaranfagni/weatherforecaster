package it.ranftesting.weatherforecaster.dto.openmeteo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OpenMeteoDTO {
    @JsonProperty("latitude")
    private Float latitude;
    @JsonProperty("longitude")
    private Float longitude;
    @JsonProperty("generationtime_ms")
    private Double generationtimeMs;
    @JsonProperty("utc_offset_seconds")
    private Integer utcOffsetSeconds;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    @JsonProperty("elevation")
    private Integer elevation;
    @JsonProperty("current_weather_units")
    private OpenMeteoCurrentWeatherUnitDTO currentWeatherUnitsDTO;
    @JsonProperty("current_weather")
    private OpenMeteoCurrentWeatherDTO currentWeatherDTO;

}
