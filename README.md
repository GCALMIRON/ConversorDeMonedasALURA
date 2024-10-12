# Challenge Conversor de Divisas en Java

Este es un conversor de divisas simple, desarrollado en Java, que permite a los usuarios 
convertir montos entre diferentes monedas utilizando tasas de cambio en tiempo real. El programa consume la API de ExchangeRate-API para obtener las tasas de cambio actualizadas.

## Características

- **Conversión en tiempo real**: Realiza conversiones utilizando las tasas de cambio más recientes.
- **Interfaz de consola**: Actualmente, el programa funciona en la consola, pero se planea desarrollar una interfaz gráfica en una próxima etapa.
- **Selección de monedas**: Permite elegir entre varias monedas predefinidas.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación utilizado para desarrollar la aplicación.
- **Gson**: Librería para la manipulación de JSON, utilizada para procesar la respuesta de la API.

## Requisitos

- Java 8 o superior.
- Conexión a Internet para acceder a la API de ExchangeRate-API.

## Uso en consola:

1) Selecciona la moneda de origen. 
2) Selecciona la moneda de destino. 
3) Ingresa la cantidad que deseas convertir.
4) El programa te devolverá la cantidad convertida entre monedas.
