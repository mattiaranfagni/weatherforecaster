package it.ranftesting.weatherforecaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class OpenMeteoCurrentWeatherDTO {
    @JsonProperty("time")
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm")
    private LocalDate time;
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

    public OpenMeteoCurrentWeatherDTO() {
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public Boolean getDay() {
        return day;
    }

    public void setDay(Boolean day) {
        this.day = day;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OpenMeteoCurrentWeatherDTO that = (OpenMeteoCurrentWeatherDTO) o;
        return Objects.equals(getTime(), that.getTime()) && Objects.equals(getInterval(), that.getInterval()) && Objects.equals(getTemperature(), that.getTemperature()) && Objects.equals(getWindSpeed(), that.getWindSpeed()) && Objects.equals(getWindDirection(), that.getWindDirection()) && Objects.equals(getDay(), that.getDay()) && Objects.equals(getWeatherCode(), that.getWeatherCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getInterval(), getTemperature(), getWindSpeed(), getWindDirection(), getDay(), getWeatherCode());
    }

    @Override
    public String toString() {
        return "OpenMeteoCurrentWeatherDTO{" +
                "time=" + time +
                ", interval=" + interval +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", day=" + day +
                ", weatherCode='" + weatherCode + '\'' +
                '}';
    }
}
