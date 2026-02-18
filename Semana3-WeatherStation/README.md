# Semana 3 - Weather Station

## Descripción

Este repositorio presenta un ejemplo de implementación del **Patrón Observer** a través de la aplicación **WeatherStation**. El sistema simula una estación meteorológica que notifica automáticamente a múltiples displays cuando hay cambios en las mediciones de temperatura, humedad y presión. En este ejercicio se implementa el Patrón Observer y aprovechando este patrón se agregan un Heat Index Display y un Pressure exclusive display.

## Patrón Observer

El Patrón Observer define una relación de dependencia uno-a-muchos entre objetos. Cuando el objeto sujeto cambia de estado, todos sus observadores dependientes son notificados y actualizados automáticamente.

### Componentes

- **Subject (WeatherData)**: Mantiene el estado y notifica a los observadores
- **Observers (Displays)**: Reciben actualizaciones y reaccionan a los cambios
- **Interfaces**: Observer y Subject definen el contrato entre componentes

## Implementación

Este proyecto incluye los siguientes displays observadores:

**CurrentConditionsDisplay**: Muestra las condiciones meteorológicas actuales (temperatura, humedad, presión)

**StatisticsDisplay**: Calcula y muestra estadísticas de temperatura (promedio, máxima, mínima)

**ForecastDisplay**: Predice el clima según cambios en la presión atmosférica

**PressureDisplay**: Display especializado que muestra únicamente la presión atmosférica

**HeatIndexDisplay**: Calcula el índice de calor combinando temperatura y humedad

**ThirdPartyDisplay**: Simula un display externo para demostrar extensibilidad

## Referencias

- Head First Design Patterns - Capítulo 2: The Observer Pattern
- Design Patterns: Elements of Reusable OO Software (Gang of Four)
