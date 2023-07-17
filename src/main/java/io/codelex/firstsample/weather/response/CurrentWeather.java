package io.codelex.firstsample.weather.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrentWeather {

    private BigDecimal temperature;
    private BigDecimal windspeed;
    private BigDecimal winddirection;
    private Integer weathercode;
    private Integer is_day;
    private LocalDateTime time;

    public CurrentWeather() {}

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(BigDecimal windspeed) {
        this.windspeed = windspeed;
    }

    public BigDecimal getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(BigDecimal winddirection) {
        this.winddirection = winddirection;
    }

    public Integer getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(Integer weathercode) {
        this.weathercode = weathercode;
    }

    public Integer getIs_day() {
        return is_day;
    }

    public void setIs_day(Integer is_day) {
        this.is_day = is_day;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
