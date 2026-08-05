package com.brianapowers.practiceweatherdashboard;

import java.util.Scanner;

public class PracticeWeatherDashboardApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        boolean running = true;

        while (running) {

            System.out.println("\n=== Weather Dashboard ===");
            System.out.println("1. St. Louis");
            System.out.println("2. Chicago");
            System.out.println("3. Miami");
            System.out.println("4. Exit");
            System.out.print("Choose a city: ");

            String choice = scanner.nextLine();

            String city;

            switch (choice) {
                case "1":
                    city = "St. Louis";
                    break;
                case "2":
                    city = "Chicago";
                    break;
                case "3":
                    city = "Miami";
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    continue;
                default:
                    System.out.println("Invalid choice. Please choose 1 through 4.");
                    continue;
            }

            try {

                WeatherResponse weather = weatherService.getWeather(city);

                System.out.println();
                System.out.println("==============================");
                System.out.println("      Current Weather");
                System.out.println("==============================");
                System.out.println("City: " + weather.getName());
                System.out.printf("Temperature: %.1f°F%n", weather.getMain().getTemp());
                System.out.println("Humidity: " + weather.getMain().getHumidity() + "%");
                System.out.println("Conditions: " + weather.getWeather().get(0).getDescription());
                System.out.println("==============================");
                System.out.println();

            } catch (Exception exception) {

                System.out.println();
                System.out.println("Unable to retrieve weather data.");
                System.out.println("Please try again.");
                System.out.println();

            }
        }

        scanner.close();
    }
}
