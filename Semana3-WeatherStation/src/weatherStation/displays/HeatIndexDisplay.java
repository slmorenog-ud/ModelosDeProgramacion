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
    // Constantes correspondientes
        final float c1 = -42.379f;
        final float c2 = 2.04901523f;
        final float c3 = 10.14333127f;
        final float c4 = -0.22475541f;
        final float c5 = -6.83783e-3f;
        final float c6 = -5.481717e-2f;
        final float c7 = 1.22874e-3f;
        final float c8 = 8.5282e-4f;
        final float c9 = -1.99e-6f;
    
        float T = temperature;
        float R = humidity;
    
        float heatIndex = (float) (
            c1 + 
           (c2 * T) + 
           (c3 * R) + 
           (c4 * T * R) + 
           (c5 * T * T) + 
           (c6 * R * R) + 
           (c7 * T * T * R) + 
           (c8 * T * R * R) + 
           (c9 * T * T * R * R) );
    
    System.out.println("Heat Index: " + heatIndex + "°F");
}