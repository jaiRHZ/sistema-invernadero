package com.itson.utilities.gatewayformat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data               // Genera automáticamente getters, setters, toString, equals y hashCode
@Builder                   // Habilita el uso del patrón Builder para construir objetos de esta clase
@AllArgsConstructor        // Genera un constructor con todos los campos
@NoArgsConstructor         // Genera un constructor vacío (sin argumentos)
/**
 * Clase Data
 * Representa una medición o dato específico dentro de un mensaje recibido desde un gateway.
 * Cada objeto Data puede describir una variable medida como temperatura, humedad, etc.
 */
public class Data {

    private String type;        // Tipo de dato
    private String magnitude;   // Magnitud de la medición
    private float value;        // Valor numérico de la magnitud medida
}

