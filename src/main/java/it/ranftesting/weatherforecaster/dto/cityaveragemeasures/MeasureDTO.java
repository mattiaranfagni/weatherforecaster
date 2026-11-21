package it.ranftesting.weatherforecaster.dto.cityaveragemeasures;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MeasureDTO {
    private Double value;
    private String unit;
}