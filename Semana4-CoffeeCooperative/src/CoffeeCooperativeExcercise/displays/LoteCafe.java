package CoffeeCooperativeExcercise.displays;

import CoffeeCooperativeExcercise.interfaces.IDisplayElement;
import CoffeeCooperativeExcercise.interfaces.IObserver;
import CoffeeCooperativeExcercise.interfaces.ISubject;

public class LoteCafe implements IObserver, IDisplayElement {
    private String varietal;
    private String notas;
    private String origen;
    private float altura;
    private String productor;
    private float cantidad;
    
    public LoteCafe(ISubject coop) {
        coop.registerObserver(this);
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
        System.out.println("=== Nuevo lote de café ===");
        System.out.println("  Varietal:   " + varietal);
        System.out.println("  Origen:     " + origen + " (Altura: " + String.format("%.0f", altura) + " msnm)");
        System.out.println("  Productor:  " + productor);
        System.out.println("  Cantidad:   " + String.format("%.1f", cantidad) + " lbs");
        System.out.println("  Notas:      " + notas);
    }
}