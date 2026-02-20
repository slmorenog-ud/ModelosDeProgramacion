import java.util.ArrayList;
import java.util.List;

/**
 * Clase Hamburger - Producto del patrón Builder
 * 
 * Representa una hamburguesa personalizada en el sistema de pedidos.
 * La clase es inmutable, lo que significa que una vez construida la instancia,
 * sus atributos no pueden modificarse.
 * 
 * Características que garantizan la inmutabilidad:
 * - Constructor privado: solo accesible desde la clase Builder
 * - Atributos declarados como final
 * - Ausencia de métodos setter
 */
public class Hamburger {
    
    // Atributos obligatorios - requeridos para toda hamburguesa
    private final String tipoPan;      // Ejemplo: "Pan Brioche", "Pan Integral"
    private final String tipoCarne;   // Ejemplo: "Carne de Res", "Carne de Pollo"
    
    // Atributos opcionales - pueden estar presentes o no
    private final String queso;      // Ejemplo: "Queso Cheddar", puede ser null
    private final List<String> ingredientes;  // Lista de ingredientes adicionales
    
    /**
     * Constructor privado
     * Solo accesible desde la clase Builder interna.
     * Implementa el patrón Builder al forzar la construcción mediante el builder.
     */
    private Hamburger(Builder builder) {
        this.tipoPan = builder.tipoPan;
        this.tipoCarne = builder.tipoCarne;
        this.queso = builder.queso;
        // Se crea una copia defensiva de la lista para preservar la inmutabilidad
        this.ingredientes = new ArrayList<>(builder.ingredientes);
    }
    
    // Métodos de acceso - solo lectura, sin setters
    
    public String getTipoPan() {
        return tipoPan;
    }
    
    public String getTipoCarne() {
        return tipoCarne;
    }
    
    public String getQueso() {
        return queso;
    }
    
    // Retorna una copia defensiva de la lista de ingredientes
    // Esto previene modificaciones externas que comprometerían la inmutabilidad
    public List<String> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }
    
    // Genera una representación textual formateada de la hamburguesa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════╗\n");
        sb.append("║         HAMBURGUESA PERSONALIZADA      ║\n");
        sb.append("╚════════════════════════════════════════╝\n");
        sb.append("  Tipo de pan: ").append(tipoPan).append("\n");
        sb.append("  Tipo de carne: ").append(tipoCarne).append("\n");
        
        if (queso != null && !queso.isEmpty()) {
            sb.append("  Queso: ").append(queso).append("\n");
        } else {
            sb.append("  Queso: Sin queso\n");
        }
        
        if (ingredientes != null && !ingredientes.isEmpty()) {
            sb.append("  Ingredientes adicionales:\n");
            for (String ingrediente : ingredientes) {
                sb.append("     - ").append(ingrediente).append("\n");
            }
        } else {
            sb.append("  Ingredientes adicionales: Ninguno\n");
        }
        
        sb.append("════════════════════════════════════════\n");
        return sb.toString();
    }
    
    /**
     * Clase Builder - Implementación del patrón Builder como clase interna estática
     * 
     * Responsable de construir instancias de Hamburger paso a paso.
     * Proceso de construcción:
     * 1. Recibe los atributos obligatorios en el constructor (pan y carne)
     * 2. Configura atributos opcionales mediante métodos fluidos
     * 3. Construye la instancia final mediante el método build()
     * 
     * Se implementa como clase interna para acceder al constructor privado
     * de Hamburger y mantener la cohesión del código.
     */
    public static class Builder {
        // Atributos obligatorios - declarados como final, se asignan en el constructor
        private final String tipoPan;
        private final String tipoCarne;
        
        // Atributos opcionales - no son final, se configuran mediante métodos
        private String queso;
        private List<String> ingredientes;
        
        /**
         * Constructor del Builder
         * Recibe únicamente los atributos obligatorios (pan y carne).
         * Valida que los parámetros no sean nulos ni cadenas vacías.
         */
        public Builder(String tipoPan, String tipoCarne) {
            if (tipoPan == null || tipoPan.trim().isEmpty()) {
                throw new IllegalArgumentException("El tipo de pan es obligatorio");
            }
            if (tipoCarne == null || tipoCarne.trim().isEmpty()) {
                throw new IllegalArgumentException("El tipo de carne es obligatorio");
            }
            
            this.tipoPan = tipoPan;
            this.tipoCarne = tipoCarne;
            this.ingredientes = new ArrayList<>();
        }
        
        //Configura el tipo de queso (atributo opcional)
        // Retorna la instancia actual para permitir encadenamiento de métodos
        public Builder conQueso(String queso) {
            this.queso = queso;
            return this;
        }
        
        //Agrega un ingrediente a la lista (atributo opcional)
        // Retorna la instancia actual para permitir encadenamiento de métodos
        public Builder agregarIngrediente(String ingrediente) {
            if (ingrediente != null && !ingrediente.trim().isEmpty()) {
                this.ingredientes.add(ingrediente);
            }
            return this;
        }
        
        //Agrega múltiples ingredientes mediante iteración
        //  Método de conveniencia que invoca agregarIngrediente() para cada elemento
        public Builder agregarIngredientes(List<String> ingredientes) {
            if (ingredientes != null) {
                for (String ingrediente : ingredientes) {
                    agregarIngrediente(ingrediente);
                }
            }
            return this;
        }
        
        // Construye y retorna la instancia final de Hamburger
        //Invoca al constructor privado pasando la instancia actual del Builder
        public Hamburger build() {
            return new Hamburger(this);
        }
    }
}