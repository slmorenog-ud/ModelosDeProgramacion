package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float temperature, humidity;
    
    public HeatIndexDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    
    public void display() {
        float heatIndex = temperature + humidity / 10;
        System.out.println("Heat Index: " + heatIndex + "°F");
    }
}
