package it.ranftesting.weatherforecaster.dto.openmeteo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OpenMeteoCurrentWeatherUnitDTO {
    @JsonProperty("time")
    private String time;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("windspeed")
    private String windSpeed;
    @JsonProperty("winddirection")
    private String windDirection;
    @JsonProperty("is_day")
    private Boolean day;
    @JsonProperty("weathercode")
    private String weatherCode;

}
