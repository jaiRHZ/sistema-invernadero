package com.itson.utilities.exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase RequestFormat
 * Esta clase se utiliza como formato estándar para encapsular peticiones.
 * Contiene un campo de contenido (generalmente JSON o texto) y un estado de respuesta.
 * Se usa comúnmente en servicios REST o intercambio de datos en sistemas distribuidos.
 */
@Data                   // Genera getters, setters, toString, equals y hashCode automáticamente
@Builder                // Permite usar el patrón Builder para crear instancias
@AllArgsConstructor     // Genera un constructor con todos los campos
@NoArgsConstructor      // Genera un constructor vacío
public class RequestFormat implements Serializable {

    private String content;

    private String method;
}
