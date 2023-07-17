package io.codelex.firstsample.weather.response;

import java.math.BigDecimal;

public class WeatherApiResponse {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal generationtime_ms;
    private Long utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private BigDecimal elevation;
    private CurrentWeather current_weather;

    public WeatherApiResponse() {

    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getGenerationtime_ms() {
        return generationtime_ms;
    }

    public void setGenerationtime_ms(BigDecimal generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public Long getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public void setUtc_offset_seconds(Long utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    public CurrentWeather getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }
}
