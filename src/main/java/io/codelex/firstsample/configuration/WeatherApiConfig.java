package io.codelex.firstsample.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weatherapi")
public class WeatherApiConfig {

    private String uri;
    private String apiKey;
    private String dateTimeFormat;


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    @Override
    public String toString() {
        return "WeatherApiConfig{" +
                "uri='" + uri + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", dateTimeFormat='" + dateTimeFormat + '\'' +
                '}';
    }
}
