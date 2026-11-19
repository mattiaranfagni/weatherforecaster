package it.ranftesting.weatherforecaster.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="opn_meteo_cur_wt", schema = "opn_mt")
public class OpenMeteoCurrentWeatherEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "opn_meteo_id")
    private LocalDate time;
    @Column(name = "opn_meteo_interval")
    private Integer interval;
    @Column(name = "opn_meteo_tmp")
    private Float temperature;
    @Column(name = "opn_meteo_wnd_sp")
    private Float windSpeed;
    @Column(name = "opn_meteo_wndd_dir")
    private Integer windDirection;
    @Column(name = "opn_meteo_is_day")
    private Boolean day;
    @Column(name = "opn_meteo_weathercode")
    private String weatherCode;

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
}
