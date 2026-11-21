package it.ranftesting.weatherforecaster.dto.cityaveragemeasures;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityAveragesDTO {
    private String city;
    private Long samples;
    private LocalDateTime from;
    private LocalDateTime to;
    private MeasureDTO temperature;
    private MeasureDTO windSpeed;
    private MeasureDTO windDirection;
    private String mostFrequentWeatherCode;
}