package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class PressureDisplay implements Observer, DisplayElement {
    private float pressure;
    
    public PressureDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
    }
    
    public void display() {
        System.out.println();
        System.out.println("=== Atmospheric Pressure ===");
        System.out.println("  Current: " + String.format("%.1f", pressure) + " mb");
    }
}
