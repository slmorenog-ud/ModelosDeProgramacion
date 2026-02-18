package weatherStation;

import weatherStation.data.WeatherData;
import weatherStation.displays.*;
import java.util.Scanner;

public class mainWeatherStation {
    public static void main(String[] args) {
        WeatherData station = new WeatherData();
        Scanner scanner = new Scanner(System.in);
        
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(station);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(station);
        ForecastDisplay forecastDisplay = new ForecastDisplay(station);
        PressureDisplay pressureDisplay = new PressureDisplay(station);
        
        System.out.println("=== Weather Station - Observer Pattern Demo ===\n");
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Current Conditions");
            System.out.println("2. Statistics");
            System.out.println("3. Forecast");
            System.out.println("4. Pressure");
            System.out.println("5. Update Weather");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                System.out.println("Bye!");
                break;
            }
            
            switch (choice) {
                case 1:
                    currentDisplay.display();
                    break;
                case 2:
                    statisticsDisplay.display();
                    break;
                case 3:
                    forecastDisplay.display();
                    break;
                case 4:
                    pressureDisplay.display();
                    break;
                case 5:
                    System.out.print("Temperature (°C): ");
                    float temp = scanner.nextFloat();
                    System.out.print("Humidity (%): ");
                    float hum = scanner.nextFloat();
                    System.out.print("Pressure (mb): ");
                    float press = scanner.nextFloat();
                    station.setMeasurements(temp, hum, press);
                    System.out.println("Weather updated! All observers notified.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}
