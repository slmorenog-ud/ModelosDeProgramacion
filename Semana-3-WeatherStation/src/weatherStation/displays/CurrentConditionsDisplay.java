package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature, humidity, pressure;
    
    public CurrentConditionsDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
    
    public void display() {
        System.out.println();
        System.out.println("=== Current Conditions ===");
        System.out.println("  Temperature: " + String.format("%.1f", temperature) + " °C");
        System.out.println("  Humidity: " + String.format("%.1f", humidity) + " %");
        System.out.println("  Pressure: " + String.format("%.1f", pressure) + " mb");
    }
}
