package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0, minTemp = 100, avgTemp = 0;
    private int count = 0;
    
    public StatisticsDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        if (temperature > maxTemp) maxTemp = temperature;
        if (temperature < minTemp) minTemp = temperature;
        avgTemp = (avgTemp * count + temperature) / (count + 1);
        count++;
    }
    
    public void display() {
        System.out.println();
        System.out.println("=== Temperature Statistics ===");
        System.out.println("  Average: " + String.format("%.1f", avgTemp) + " °C");
        System.out.println("  Maximum: " + String.format("%.1f", maxTemp) + " °C");
        System.out.println("  Minimum: " + String.format("%.1f", minTemp) + " °C");
    }
}
