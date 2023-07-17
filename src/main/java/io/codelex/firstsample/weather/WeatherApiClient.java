package io.codelex.firstsample.weather;

import io.codelex.firstsample.weather.response.CurrentWeather;

public interface WeatherApiClient {

    CurrentWeather getWeatherFromApi();

}
