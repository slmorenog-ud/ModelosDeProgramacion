package CoffeeCooperativeExcercise.displays;

import CoffeeCooperativeExcercise.interfaces.IDisplayElement;
import CoffeeCooperativeExcercise.interfaces.IObserver;
import CoffeeCooperativeExcercise.interfaces.ISubject;

public class Barista implements IObserver, IDisplayElement {
    private String name;
    private String id;
    private String varietal;
    private float altura;
    private float cantidad;
    private String notas;
    private String origen;
    private String productor;

    public Barista(String name, String id, ISubject coop) {
        this.name = name;
        this.id = id;
        coop.registerObserver(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String varietal, String notas, String origen, float altura, String productor, float cantidad) {
        this.varietal = varietal;
        this.notas = notas;
        this.origen = origen;
        this.altura = altura;
        this.productor = productor;
        this.cantidad = cantidad;
        display();
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Nuevo lote de café disponible ===");
        System.out.println("Barista: " + name + " (ID: " + id + ")");
        System.out.println("  Varietal:   " + varietal);
        System.out.println("  Origen:     " + origen);
        System.out.println("  Altura:     " + String.format("%.0f", altura) + " msnm");
        System.out.println("  Cantidad:   " + String.format("%.1f", cantidad) + " lbs");
        System.out.println("  Notas:      " + notas);
        System.out.println("  Productor:  " + productor);
    }
}