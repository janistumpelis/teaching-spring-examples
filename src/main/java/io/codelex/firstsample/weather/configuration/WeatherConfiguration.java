package io.codelex.firstsample.weather.configuration;

import io.codelex.firstsample.weather.WeatherApiClient;
import io.codelex.firstsample.weather.WeatherApiClientNew;
import io.codelex.firstsample.weather.WeatherApiClientOld;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfiguration {

    @Bean
    @ConditionalOnProperty(prefix="weather", name="apiversion", havingValue = "v1")
    public WeatherApiClient getOldVersion() {
        return new WeatherApiClientOld();
    }


    @Bean
    @ConditionalOnProperty(prefix="weather", name="apiversion", havingValue = "v2")
    public WeatherApiClient getNewVersion(@Value("${weatherapi.uri}") String url) {
        return new WeatherApiClientNew(url);
    }

    //Alternative
//
//    @Value("${weather.apiversion}")
//    private String weatherApiVersion;
//
//    @Value("${weatherapi.uri}")
//    private String url;
//
//    @Bean
//    public WeatherApiClient chooseApiClient() {
//        if ("v1".equals(weatherApiVersion)) {
//            return new WeatherApiClientOld();
//        } else if ("v2".equals(weatherApiVersion)) {
//            return new WeatherApiClientNew(url);
//        } else {
//            throw new RuntimeException("Could not configure weather api version");
//        }
//    }
}
