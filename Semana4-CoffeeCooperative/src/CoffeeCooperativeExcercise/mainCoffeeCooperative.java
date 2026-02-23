package CoffeeCooperativeExcercise;

import CoffeeCooperativeExcercise.data.Cooperative;
import CoffeeCooperativeExcercise.displays.Barista;
import java.util.Scanner;

public class mainCoffeeCooperative {
    public static void main(String[] args) {
        Cooperative coop = new Cooperative();
        Scanner scanner = new Scanner(System.in);
        Barista[] baristas = new Barista[50];
        int baristaCount = 0;

        System.out.println("=== Cooperativa de Cafés ===\n");

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear y suscribir nuevo barista");
            System.out.println("2. Registrar nuevo lote de café");
            System.out.println("3. Eliminar suscripción de barista");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nombre del barista: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Identificacion del barista: ");
                    String id = scanner.nextLine();
                    baristas[baristaCount] = new Barista(nombre, id, coop);
                    baristaCount++;
                    System.out.println("Barista " + nombre + " suscrito correctamente.");
                    break;

                case "2":
                    if (baristaCount == 0) {
                        System.out.println("No hay baristas suscritos. Registre al menos uno primero.");
                        break;
                    }
                    System.out.print("Varietal: ");
                    String varietal = scanner.nextLine();
                    System.out.print("Notas de cata: ");
                    String notas = scanner.nextLine();
                    System.out.print("Lugar de origen: ");
                    String origen = scanner.nextLine();
                    System.out.print("Altura de cultivo (msnm): ");
                    float altura = Float.parseFloat(scanner.nextLine());
                    System.out.print("Nombre del productor: ");
                    String productor = scanner.nextLine();
                    System.out.print("Cantidad disponible (lbs): ");
                    float cantidad = Float.parseFloat(scanner.nextLine());
                    System.out.println("\n[Notificando a todos los baristas suscritos...]\n");
                    coop.registerLot(varietal, notas, origen, altura, productor, cantidad);
                    break;

                case "3":
                    if (baristaCount == 0) {
                        System.out.println("No hay baristas suscritos.");
                        break;
                    }
                    System.out.println("Baristas suscritos:");
                    for (int i = 0; i < baristaCount; i++) {
                        System.out.println("  " + (i + 1) + ". " + baristas[i].getName());
                    }
                    System.out.print("Seleccione el número a eliminar (0 para cancelar): ");
                    int idx = Integer.parseInt(scanner.nextLine()) - 1;
                    if (idx >= 0 && idx < baristaCount) {
                        String eliminado = baristas[idx].getName();
                        coop.removeObserver(baristas[idx]);
                        for (int j = idx; j < baristaCount - 1; j++) {
                            baristas[j] = baristas[j + 1];
                        }
                        baristas[--baristaCount] = null;
                        System.out.println("Barista " + eliminado + " eliminado de la cooperativa.");
                    }
                    break;

                case "0":
                    System.out.println("Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}
