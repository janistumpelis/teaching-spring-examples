package io.codelex.firstsample.weather;

import io.codelex.firstsample.weather.response.CurrentWeather;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WeatherService {

    private WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public String getWeather() {
        CurrentWeather weather = weatherApiClient.getWeatherFromApi();
        BigDecimal temperature = weather.getTemperature();
        BigDecimal windSpeed = weather.getWindspeed();
        return "Current temperature is " + temperature + " and wind speed is: " + windSpeed + " m/s";
    }

}
