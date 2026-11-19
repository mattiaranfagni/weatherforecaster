package it.ranftesting.weatherforecaster.entity;

import jakarta.persistence.*;

@Entity
@Table(name="opn_meteo_cur_wt_unit", schema = "opn_mt")
public class OpenMeteoCurrentWeatherUnitEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "opn_meteo_id")
    private String time;
    @Column(name = "opn_meteo_interval")
    private String interval;
    @Column(name = "opn_meteo_tmp")
    private String temperature;
    @Column(name = "opn_meteo_wnd_sp")
    private String windSpeed;
    @Column(name = "opn_meteo_wndd_dir")
    private String windDirection;
    @Column(name = "opn_meteo_is_day")
    private Boolean day;
    @Column(name = "opn_meteo_weathercode")
    private String weatherCode;

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
}
