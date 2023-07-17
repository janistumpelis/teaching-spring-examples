package io.codelex.firstsample.weather;

import io.codelex.firstsample.weather.response.CurrentWeather;
import io.codelex.firstsample.weather.response.WeatherApiResponse;
import org.springframework.web.reactive.function.client.WebClient;

//Dependency: implementation 'org.springframework.boot:spring-boot-starter-webflux'

public class WeatherApiClientNew implements WeatherApiClient {

    private final WebClient webClient;

    public WeatherApiClientNew(String url) {
        this.webClient = WebClient.create(url);
    }

    public CurrentWeather getWeatherFromApi() {
        WeatherApiResponse response = webClient.get().retrieve().bodyToMono(WeatherApiResponse.class).block();
        return response.getCurrent_weather();
    }

}
