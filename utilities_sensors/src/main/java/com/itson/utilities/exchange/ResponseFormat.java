package com.itson.utilities.exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * Clase ResponseFormat
 * Representa un formato estándar de respuesta para el intercambio de datos en sistemas distribuidos o servicios web.
 * Esta clase encapsula el contenido de la respuesta y un código de estado asociado.
 */
@Data                   // Lombok: genera automáticamente los métodos getter, setter, toString, equals y hashCode
@Builder                // Lombok: permite construir objetos de esta clase con el patrón de diseño Builder
@AllArgsConstructor     // Lombok: constructor con todos los atributos
@NoArgsConstructor      // Lombok: constructor sin argumentos
public class ResponseFormat implements Serializable {

    private String content;        // Campo que contiene el cuerpo o contenido de la respuesta (generalmente en formato JSON o texto)
    private int responseStatus;    // Código de estado de la respuesta (por ejemplo, 200 para OK, 400 para error de cliente, etc.)
}
