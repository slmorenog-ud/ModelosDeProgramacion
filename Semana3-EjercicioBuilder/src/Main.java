public class Main {
    public static void main(String[] args) {
        System.out.println("\n==============================================");
        System.out.println("  SISTEMA DE PEDIDOS - HAMBURGUESAS");
        System.out.println("==============================================\n");
        
        System.out.println(">>> PEDIDO #1: Hamburguesa Clásica con Queso\n");
        
        Hamburger hamburguesaClasica = new Hamburger.Builder("Pan Brioche", "Carne de Res")
                .conQueso("Queso Cheddar")
                .agregarIngrediente("Lechuga")
                .agregarIngrediente("Tomate")
                .agregarIngrediente("Cebolla")
                .agregarIngrediente("Pepinillos")
                .agregarIngrediente("Salsa especial")
                .build();
        
        System.out.println(hamburguesaClasica);
        
        System.out.println("\n>>> PEDIDO #2: Hamburguesa Simple\n");
        
        Hamburger hamburguesaSimple = new Hamburger.Builder("Pan Integral", "Carne de Pollo")
                .build();
        
        System.out.println(hamburguesaSimple);
        
        System.out.println("\n>>> PEDIDO #3: Hamburguesa Vegetariana Gourmet\n");
        
        Hamburger hamburguesaVegetariana = new Hamburger.Builder("Pan de Centeno", "Carne Vegetariana (Beyond Meat)")
                .conQueso("Queso Suizo")
                .agregarIngrediente("Rúcula")
                .agregarIngrediente("Tomate Cherry")
                .agregarIngrediente("Cebolla Caramelizada")
                .agregarIngrediente("Aguacate")
                .agregarIngrediente("Mayonesa de Chipotle")
                .agregarIngrediente("Espinacas")
                .build();
        
        System.out.println(hamburguesaVegetariana);
        
        System.out.println("\n>>> PEDIDO #4: Hamburguesa BBQ Premium\n");
        
        Hamburger hamburguesaBBQ = new Hamburger.Builder("Pan Blanco", "Carne de Cerdo")
                .conQueso("Queso Americano")
                .agregarIngrediente("Bacon Crocante")
                .agregarIngrediente("Aros de Cebolla")
                .agregarIngrediente("Salsa BBQ")
                .agregarIngrediente("Jalapeños")
                .build();
        
        System.out.println(hamburguesaBBQ);
        
        System.out.println("\n>>> DEMOSTRACIÓN DE INMUTABILIDAD\n");
        System.out.println("Las hamburguesas son inmutables.");
        System.out.println("Los getters proporcionan copias defensivas.\n");
        
        var ingredientes = hamburguesaClasica.getIngredientes();
        System.out.println("Ingredientes de la hamburguesa clásica: " + ingredientes);
        
        System.out.println("\n==============================================");
        System.out.println("  FIN");
        System.out.println("==============================================\n");
    }
}

        