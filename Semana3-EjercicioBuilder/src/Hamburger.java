import java.util.ArrayList;
import java.util.List;

public class Hamburger {
    
    private final String tipoPan;
    private final String tipoCarne;
    private final String queso;
    private final List<String> ingredientes;
    
    private Hamburger(Builder builder) {
        this.tipoPan = builder.tipoPan;
        this.tipoCarne = builder.tipoCarne;
        this.queso = builder.queso;
        this.ingredientes = new ArrayList<>(builder.ingredientes);
    }
    
    public String getTipoPan() {
        return tipoPan;
    }
    
    public String getTipoCarne() {
        return tipoCarne;
    }
    
    public String getQueso() {
        return queso;
    }
    
    public List<String> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }
    
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
    
    public static class Builder {
        private final String tipoPan;
        private final String tipoCarne;
        private String queso;
        private List<String> ingredientes;
        
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
        
        public Builder conQueso(String queso) {
            this.queso = queso;
            return this;
        }
        
        public Builder agregarIngrediente(String ingrediente) {
            if (ingrediente != null && !ingrediente.trim().isEmpty()) {
                this.ingredientes.add(ingrediente);
            }
            return this;
        }
        
        public Builder agregarIngredientes(List<String> ingredientes) {
            if (ingredientes != null) {
                for (String ingrediente : ingredientes) {
                    agregarIngrediente(ingrediente);
                }
            }
            return this;
        }
        
        public Hamburger build() {
            return new Hamburger(this);
        }
    }
}