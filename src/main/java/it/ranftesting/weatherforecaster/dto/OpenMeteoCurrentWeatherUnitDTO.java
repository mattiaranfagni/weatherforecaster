package it.ranftesting.weatherforecaster.dto;

import java.util.Objects;

public class OpenMeteoCurrentWeatherUnitDTO {
    private String time;
    private String interval;
    private String temperature;
    private String windSpeed;
    private String windDirection;
    private Boolean day;
    private String weatherCode;

    public OpenMeteoCurrentWeatherUnitDTO() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
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
        OpenMeteoCurrentWeatherUnitDTO that = (OpenMeteoCurrentWeatherUnitDTO) o;
        return Objects.equals(getTime(), that.getTime()) && Objects.equals(getInterval(), that.getInterval()) && Objects.equals(getTemperature(), that.getTemperature()) && Objects.equals(getWindSpeed(), that.getWindSpeed()) && Objects.equals(getWindDirection(), that.getWindDirection()) && Objects.equals(getDay(), that.getDay()) && Objects.equals(getWeatherCode(), that.getWeatherCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getInterval(), getTemperature(), getWindSpeed(), getWindDirection(), getDay(), getWeatherCode());
    }

    @Override
    public String toString() {
        return "OpenMeteoCurrentWeatherUnitDTO{" +
                "time='" + time + '\'' +
                ", interval='" + interval + '\'' +
                ", temperature='" + temperature + '\'' +
                ", windspeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", day=" + day +
                ", weatherCode='" + weatherCode + '\'' +
                '}';
    }
}
