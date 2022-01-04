package observer;

public class WeatherStation {

    public static void main(String[] args) {
        final var weatherData = new WeatherData();
        final var currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}
