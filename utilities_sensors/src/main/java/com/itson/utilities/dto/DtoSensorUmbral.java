package com.itson.utilities.dto;

import java.io.Serializable;

/**
 * Clase DtoSensorUmbral
 * Representa la relación entre un sensor y un umbral específico.
 * Sirve para asignar un umbral concreto a un sensor determinado.
 */
public class DtoSensorUmbral implements Serializable {

    // Identificador único de la relación entre sensor y umbral
    private Long id_sensor_umbral;

    // Objeto que representa el umbral asignado al sensor
    private DtoUmbral dto_umbral;

    // Identificador del sensor al que se le asigna el umbral
    private Long id_sensor;

    /**
     * Constructor vacío necesario para frameworks de serialización.
     */
    public DtoSensorUmbral() {
    }

    /**
     * Constructor sin ID de relación.
     * @param dto_umbral Objeto del umbral asignado
     * @param id_sensor ID del sensor asociado
     */
    public DtoSensorUmbral(DtoUmbral dto_umbral, Long id_sensor) {
        this.dto_umbral = dto_umbral;
        this.id_sensor = id_sensor;
    }

    /**
     * Constructor completo con ID de relación.
     * @param id_sensor_umbral ID de la relación sensor-umbral
     * @param dto_umbral Umbral asignado
     * @param id_sensor ID del sensor
     */
    public DtoSensorUmbral(Long id_sensor_umbral, DtoUmbral dto_umbral, Long id_sensor) {
        this.id_sensor_umbral = id_sensor_umbral;
        this.dto_umbral = dto_umbral;
        this.id_sensor = id_sensor;
    }

    // Getters y setters

    public Long getId_sensor_umbral() {
        return id_sensor_umbral;
    }

    public void setId_sensor_umbral(Long id_sensor_umbral) {
        this.id_sensor_umbral = id_sensor_umbral;
    }

    public DtoUmbral getDto_umbral() {
        return dto_umbral;
    }

    public void setDto_umbral(DtoUmbral dto_umbral) {
        this.dto_umbral = dto_umbral;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    /**
     * Representación textual del objeto, útil para logs y depuración.
     */
    @Override
    public String toString() {
        return "DtoSensorUmbral{" +
                "id_sensor_umbral=" + id_sensor_umbral +
                ", dto_umbral=" + dto_umbral +
                ", id_sensor=" + id_sensor +
                '}';
    }
}
