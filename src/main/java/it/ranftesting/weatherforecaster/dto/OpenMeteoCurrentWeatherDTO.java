package it.ranftesting.weatherforecaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OpenMeteoCurrentWeatherDTO {
    @JsonProperty("time")
    private LocalDateTime time;
    @JsonProperty("interval")
    private Integer interval;
    @JsonProperty("temperature")
    private Float temperature;
    @JsonProperty("windspeed")
    private Float windSpeed;
    @JsonProperty("winddirection")
    private Integer windDirection;
    @JsonProperty("is_day")
    private Boolean day;
    @JsonProperty("weathercode")
    private String weatherCode;

}
