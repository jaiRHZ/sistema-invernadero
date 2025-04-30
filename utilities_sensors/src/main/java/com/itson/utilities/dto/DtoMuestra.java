
package com.itson.utilities.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase DtoMuestra
 * Representa un objeto de transferencia de datos (DTO) que contiene información sobre una muestra tomada por un sensor.
 * Implementa Serializable para permitir su uso en procesos de serialización y deserialización.
 */
public class DtoMuestra implements Serializable {

    // Identificador único de la muestra
    private Long id_muestra;

    // Tipo de muestra (por ejemplo, temperatura, humedad, etc.)
    private String tipo;

    // Magnitud asociada a la muestra (por ejemplo, °C, %, etc.)
    private String magnitud;

    // Fecha y hora en que se tomó la muestra
    private LocalDateTime fechaHora_muestra;

    // Valor numérico de la muestra
    private Float valor;

    // Identificador del sensor que tomó la muestra
    private Long id_sensor;

    /**
     * Constructor vacío necesario para frameworks y bibliotecas de serialización.
     */
    public DtoMuestra() {
    }

    /**
     * Constructor para inicializar una muestra sin ID (útil para nuevos registros).
     *
     * @param tipo              Tipo de muestra
     * @param magnitud          Unidad de medida
     * @param fechaHora_muestra Fecha y hora de la muestra
     * @param valor             Valor medido
     * @param id_sensor         Identificador del sensor asociado
     */
    public DtoMuestra(String tipo, String magnitud, LocalDateTime fechaHora_muestra, Float valor, Long id_sensor) {
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.fechaHora_muestra = fechaHora_muestra;
        this.valor = valor;
        this.id_sensor = id_sensor;
    }

    /**
     * Constructor para inicializar una muestra con todos los atributos, incluyendo su ID.
     *
     * @param id_muestra        Identificador único de la muestra
     * @param tipo              Tipo de muestra
     * @param magnitud          Unidad de medida
     * @param fechaHora_muestra Fecha y hora de la muestra
     * @param valor             Valor medido
     * @param id_sensor         Identificador del sensor asociado
     */
    public DtoMuestra(Long id_muestra, String tipo, String magnitud, LocalDateTime fechaHora_muestra, Float valor, Long id_sensor) {
        this.id_muestra = id_muestra;
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.fechaHora_muestra = fechaHora_muestra;
        this.valor = valor;
        this.id_sensor = id_sensor;
    }

    // Métodos de acceso (getters) y modificación (setters)

    public Long getId_muestra() {
        return id_muestra;
    }

    public void setId_muestra(Long id_muestra) {
        this.id_muestra = id_muestra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public LocalDateTime getFechaHora_muestra() {
        return fechaHora_muestra;
    }

    public void setFechaHora_muestra(LocalDateTime fechaHora_muestra) {
        this.fechaHora_muestra = fechaHora_muestra;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    /**
     * Representación en cadena de texto del objeto DtoMuestra.
     * Útil para depuración o logging.
     */
    @Override
    public String toString() {
        return "DtoMuestra{" +
                "id_muestra=" + id_muestra +
                ", tipo='" + tipo + '\'' +
                ", magnitud='" + magnitud + '\'' +
                ", fechaHora_muestra=" + fechaHora_muestra +
                ", valor=" + valor +
                ", id_sensor=" + id_sensor +
                '}';
    }
}
