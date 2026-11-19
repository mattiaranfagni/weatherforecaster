package it.ranftesting.weatherforecaster.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.ranftesting.weatherforecaster.dto.OpenMeteoCurrentWeatherDTO;
import it.ranftesting.weatherforecaster.dto.OpenMeteoCurrentWeatherUnitDTO;
import jakarta.persistence.*;

@Entity
@Table(name="opn_meteo", schema = "opn_mt")
public class OpenMeteoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "opn_meteo_id")
    private Long id;
    @Column(name = "opn_meteo_lat", nullable=false)
    private Float latitude;
    @Column(name = "opn_meteo_lon", nullable=false)
    private Float longitude;
    @Column(name = "opn_meteo_gen_time_ms")
    private Double generationtimeMs;
    @Column(name = "opn_meteo_otc_off_sec")
    private Integer utcOffsetSeconds;
    @Column(name = "opn_meteo_timezone")
    private String timezone;
    @Column(name = "opn_meteo_timezone_abbr")
    private String timezoneAbbreviation;
    @Column(name = "opn_meteo_elev")
    private Integer elevation;

    @OneToOne(cascade = CascadeType.ALL)
    private OpenMeteoCurrentWeatherUnitEntity currentWeatherUnitsDTO;
    @OneToOne(cascade = CascadeType.ALL)
    private OpenMeteoCurrentWeatherEntity currentWeatherDTO;
    public OpenMeteoEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(Double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    public Integer getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(Integer utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public OpenMeteoCurrentWeatherUnitEntity getCurrentWeatherUnitsDTO() {
        return currentWeatherUnitsDTO;
    }

    public void setCurrentWeatherUnitsDTO(OpenMeteoCurrentWeatherUnitEntity currentWeatherUnitsDTO) {
        this.currentWeatherUnitsDTO = currentWeatherUnitsDTO;
    }

    public OpenMeteoCurrentWeatherEntity getCurrentWeatherDTO() {
        return currentWeatherDTO;
    }

    public void setCurrentWeatherDTO(OpenMeteoCurrentWeatherEntity currentWeatherDTO) {
        this.currentWeatherDTO = currentWeatherDTO;
    }
}
