package CoffeeCooperativeExcercise.data;

import CoffeeCooperativeExcercise.interfaces.IObserver;
import CoffeeCooperativeExcercise.interfaces.ISubject;

public class Cooperative implements ISubject {
    private IObserver[] observers = new IObserver[50];
    private int count = 0;
    private String varietal;
    private String notas;
    private String origen;
    private float altura;
    private String productor;
    private float cantidad;

    public void registerObserver(IObserver o) {
        if (count < observers.length) {
            observers[count++] = o;
        }
    }

    public void removeObserver(IObserver o) {
        for (int i = 0; i < count; i++) {
            if (observers[i].equals(o)) {
                for (int j = i; j < count - 1; j++) {
                    observers[j] = observers[j + 1];
                }
                observers[--count] = null;
                break;
            }
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < count; i++) {
            observers[i].update(varietal, notas, origen, altura, productor, cantidad);
        }
    }

    public void registerLot(String varietal, String notas, String origen, float altura, String productor, float cantidad) {
        this.varietal = varietal;
        this.notas = notas;
        this.origen = origen;
        this.altura = altura;
        this.productor = productor;
        this.cantidad = cantidad;
        notifyObservers();
    }
}