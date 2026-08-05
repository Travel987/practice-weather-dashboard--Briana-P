package com.brianapowers.practiceweatherdashboard;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

private static final String API_KEY = System.getenv("OPENWEATHER_API_KEY");
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String city) {

        String url =
                "https://api.openweathermap.org/data/2.5/weather"
                        + "?q=" + city
                        + "&appid=" + API_KEY
                        + "&units=imperial";

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}

