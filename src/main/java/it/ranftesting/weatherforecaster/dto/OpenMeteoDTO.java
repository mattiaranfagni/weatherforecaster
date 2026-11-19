package it.ranftesting.weatherforecaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

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

    public OpenMeteoDTO() {
        this.currentWeatherDTO = new OpenMeteoCurrentWeatherDTO();
        this.currentWeatherUnitsDTO = new OpenMeteoCurrentWeatherUnitDTO();
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

    public OpenMeteoCurrentWeatherUnitDTO getCurrentWeatherUnitsDTO() {
        return currentWeatherUnitsDTO;
    }

    public void setCurrentWeatherUnitsDTO(OpenMeteoCurrentWeatherUnitDTO currentWeatherUnitsDTO) {
        this.currentWeatherUnitsDTO = currentWeatherUnitsDTO;
    }

    public OpenMeteoCurrentWeatherDTO getCurrentWeatherDTO() {
        return currentWeatherDTO;
    }

    public void setCurrentWeatherDTO(OpenMeteoCurrentWeatherDTO currentWeatherDTO) {
        this.currentWeatherDTO = currentWeatherDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OpenMeteoDTO that = (OpenMeteoDTO) o;
        return Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getLongitude(), that.getLongitude()) && Objects.equals(getGenerationtimeMs(), that.getGenerationtimeMs()) && Objects.equals(getUtcOffsetSeconds(), that.getUtcOffsetSeconds()) && Objects.equals(getTimezone(), that.getTimezone()) && Objects.equals(getTimezoneAbbreviation(), that.getTimezoneAbbreviation()) && Objects.equals(getElevation(), that.getElevation()) && Objects.equals(getCurrentWeatherUnitsDTO(), that.getCurrentWeatherUnitsDTO()) && Objects.equals(getCurrentWeatherDTO(), that.getCurrentWeatherDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude(), getGenerationtimeMs(), getUtcOffsetSeconds(), getTimezone(), getTimezoneAbbreviation(), getElevation(), getCurrentWeatherUnitsDTO(), getCurrentWeatherDTO());
    }

    @Override
    public String toString() {
        return "OpenMeteoDTO{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationtimeMs=" + generationtimeMs +
                ", utcOffsetSeconds=" + utcOffsetSeconds +
                ", timezone='" + timezone + '\'' +
                ", timezoneAbbreviation='" + timezoneAbbreviation + '\'' +
                ", elevation=" + elevation +
                ", currentWeatherUnitsDTO=" + currentWeatherUnitsDTO +
                ", currentWeatherDTO=" + currentWeatherDTO +
                '}';
    }
}
