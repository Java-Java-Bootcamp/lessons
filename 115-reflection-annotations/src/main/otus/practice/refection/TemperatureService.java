package main.otus.practice.refection;

public class TemperatureService {
    private Integer temperature = 0;

    public void init() {
        Service service = new Service();
        temperature = service.getTemperatureInCelsius();
    }

    private Integer convertToFahrenheit(int a) {
        return a + 32;
    }

    public String getTemperatureInformationInFahrenheit() {
        return "temperature in fahrenheit is: " + convertToFahrenheit(temperature);
    }

    private static class Service {
        public int getTemperatureInCelsius() {
            return 10;
        }
    }

}
