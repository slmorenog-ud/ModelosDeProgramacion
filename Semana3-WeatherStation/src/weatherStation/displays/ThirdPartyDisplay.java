package weatherStation.displays;

import weatherStation.interfaces.Observer;
import weatherStation.interfaces.Subject;
import weatherStation.interfaces.DisplayElement;

public class ThirdPartyDisplay implements Observer, DisplayElement {
    private float temperature, humidity, pressure;
    
    public ThirdPartyDisplay(Subject station) {
        station.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("Third Party Display: T=" + temperature + "°F, H=" + humidity + "%, P=" + pressure + " in");
    }
}
