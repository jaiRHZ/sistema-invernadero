package com.itson.utilities.gatewayformat;

import java.util.List;
import com.itson.utilities.gatewayformat.Data;

@lombok.Data               // Genera automáticamente getters, setters, toString, equals y hashCode
@lombok.Builder            // Permite crear instancias de la clase utilizando el patrón Builder
@lombok.AllArgsConstructor // Genera un constructor con todos los campos
@lombok.NoArgsConstructor  // Genera un constructor vacío (sin argumentos)
/**
 * Clase MessageFormat
 * Representa el formato de un mensaje recibido o enviado desde un gateway (puerta de enlace),
 * utilizado posiblemente en sistemas IoT o de monitoreo.
 */
public class MessageFormat {

    private String serie;           // Identificador único de la serie o conjunto de datos
    private String date;            // Fecha en la que se generó el mensaje (posiblemente en formato ISO 8601)
    private List<Data> data;        // Lista de objetos Data, que contiene las mediciones o datos asociados al mensaje
    private int interval;           // Intervalo de tiempo (en segundos, minutos, etc.) entre las mediciones
    private String gateway;         // Identificador del gateway que envió el mensaje

    // Constructor adicional que omite el campo "gateway"
    public MessageFormat(String serie, String date, List<Data> data, int interval) {
        this.serie = serie;
        this.date = date;
        this.data = data;
        this.interval = interval;
    }
}

