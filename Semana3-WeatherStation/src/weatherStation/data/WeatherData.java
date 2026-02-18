package weatherStation.data;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;

public class WeatherData implements Subject {
    private Observer[] observers = new Observer[10];
    private int count = 0;
    private float temperature, humidity, pressure;
    
    public void registerObserver(Observer o) {
        observers[count++] = o;
    }
    
    public void removeObserver(Observer o) {
        // No implementado a detalle para simplificar
    }

    public void notifyObservers() {
        for (int i = 0; i < count; i++) {
            observers[i].update(temperature, humidity, pressure);
        }
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
