package com.brianapowers.practiceweatherdashboard;

import java.util.List;
public class WeatherResponse {
    private String name;
    private MainWeather main;
    private List<WeatherDescription> weather;

    public String getName() {
        return name;
    }

    public MainWeather getMain() {
        return main;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }
}

