# Taller Bridge - Semana 2

Implementación del patrón de diseño **Bridge** para publicación de contenido en múltiples plataformas.

## Estructura

```
src/
├── plataforma/    (Implementación: Instagram, TikTok, X, YouTube)
├── contenido/     (Abstracción: Foto, Historia, VideoCorto, Hilo)
└── app/           (Test.java)
```

## Ejecutar

```bash
javac -d build/classes src/plataforma/*.java src/contenido/*.java src/app/*.java
java -cp build/classes app.Test
```

## Patrón Bridge

- **Sin Bridge**: 4 tipos × 4 plataformas = 16 clases
- **Con Bridge**: 4 + 4 = 8 clases (50% reducción)
- ✅ Sin condicionales
- ✅ Cambio dinámico de plataforma
- ✅ Fácil extensión
