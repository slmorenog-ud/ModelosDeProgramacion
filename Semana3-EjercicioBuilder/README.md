# Semana 3 - Ejercicio Builder: Sistema de Hamburguesas

## Descripción

Implementación del **Patrón Builder** para la creación de hamburguesas personalizadas en un sistema de pedidos de comida rápida

## Estructura de la Solución

### Clase `Hamburger`

**Atributos obligatorios:**
- `tipoPan`: String
- `tipoCarne`: String

**Atributos opcionales:**
- `queso`: String
- `ingredientes`: List<String>

**Características:**
- Constructor privado
- Atributos `final` (inmutable)
- Método `toString()` formateado

## Diagrama de Clases

<img alt="DiagramaBuilder" src="https://github.com/user-attachments/assets/d2ab85a1-9d77-4971-a66e-8d9343fa8dd3" />


### Clase `Hamburger.Builder`

**Métodos:**
- `Builder(String tipoPan, String tipoCarne)`: Constructor con obligatorios
- `conQueso(String queso)`: Configura el queso
- `agregarIngrediente(String ingrediente)`: Agrega un ingrediente
- `build()`: Construye la hamburguesa

## Ejemplo de Uso

```java
Hamburger hamburguesaClasica = new Hamburger.Builder("Pan Brioche", "Carne de Res")
        .conQueso("Queso Cheddar")
        .agregarIngrediente("Lechuga")
        .agregarIngrediente("Tomate")
        .agregarIngrediente("Cebolla")
        .agregarIngrediente("Pepinillos")
        .agregarIngrediente("Salsa especial")
        .build();

Hamburger hamburguesaSimple = new Hamburger.Builder("Pan Integral", "Carne de Pollo")
        .build();
```

## Referencias

- Head First Design Patterns - Capítulo 3: The Builder Pattern
- Design Patterns: Elements of Reusable OO Software (Gang of Four)
