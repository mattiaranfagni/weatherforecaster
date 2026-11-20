package it.ranftesting.weatherforecaster.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.ranftesting.weatherforecaster.dto.OpenMeteoCurrentWeatherDTO;
import it.ranftesting.weatherforecaster.dto.OpenMeteoCurrentWeatherUnitDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "opn_meteo", schema = "opn_mt")
@Getter
@Setter
@NoArgsConstructor
public class OpenMeteoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opn_meteo_id")
    private Long id;

    @Column(name = "opn_meteo_lat", nullable = false)
    private Float latitude;

    @Column(name = "opn_meteo_lon", nullable = false)
    private Float longitude;

    @Column(name = "opn_meteo_gen_timestamp")
    private Date generationTimestamp;

    @Column(name = "opn_meteo_elev")
    private Integer elevation;

    @Column(name = "opn_meteo_time")
    private LocalDateTime time;

    @Column(name = "opn_meteo_time_unit")
    private String timeUnit;

    @Column(name = "opn_meteo_interval")
    private Integer interval;

    @Column(name = "opn_meteo_interval_unit")
    private String intervalUnit;

    @Column(name = "opn_meteo_temp")
    private Float temperature;

    @Column(name = "opn_meteo_temp_unit")
    private String temperatureUnit;

    @Column(name = "opn_meteo_wnd_sp")
    private Float windSpeed;

    @Column(name = "opn_meteo_wnd_sp_unit")
    private String windSpeedUnit;

    @Column(name = "opn_meteo_wnd_dir")
    private Integer windDirection;

    @Column(name = "opn_meteo_is_day")
    private Boolean day;

    @Column(name = "opn_meteo_weathercode")
    private String weatherCode;

}