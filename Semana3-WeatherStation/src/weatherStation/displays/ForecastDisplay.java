package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure, currentPressure;
    
    public ForecastDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
    }
    
    public void display() {
        System.out.println();
        System.out.println("=== Weather Forecast ===");
        if (currentPressure > lastPressure) {
            System.out.println("  Prediction: Better weather on the way!");
        } else if (currentPressure < lastPressure) {
            System.out.println("  Prediction: Watch out for rainy weather");
        } else {
            System.out.println("  Prediction: More of the same weather");
        }
    }
}
