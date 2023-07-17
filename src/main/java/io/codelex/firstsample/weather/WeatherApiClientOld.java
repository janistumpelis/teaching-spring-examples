package io.codelex.firstsample.weather;

import io.codelex.firstsample.weather.response.CurrentWeather;
import io.codelex.firstsample.weather.response.WeatherApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class WeatherApiClientOld implements WeatherApiClient {

    @Value("${weatherapi.uri}")
    private String weatherApiUri;

    Logger logger = LoggerFactory.getLogger(WeatherApiClientOld.class);

    public CurrentWeather getWeatherFromApi() {

        if (weatherApiUri.isBlank()) {
            logger.error("Incorrect config, weather api url not provided!");
            throwServiceUnavailableError();
        }

        WeatherApiResponse response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(weatherApiUri, WeatherApiResponse.class);
        } catch (Exception e) {
            logger.error("Error happened during weather API call!", e);
            throwServiceUnavailableError();
        }

        return response.getCurrent_weather();
    }

    private void throwServiceUnavailableError() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not retrieve weather data!");
    }

}
