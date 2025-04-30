
package com.itson.utilities.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase dtoAlarm
 * Representa un objeto de transferencia de datos (DTO) para una alarma.
 * Implementa Serializable para permitir su serialización.
 */
public class DtoAlarma implements Serializable {

    // Identificador único de la alarma
    private Long id_alarma;

    // Tipo de alarma, representado por un enumerador
    private TipoAlarmaEnum tipoAlarmaEnum;

    // Fecha y hora en que se registró la alarma
    private LocalDateTime fechaHora_alarma;

    // Valor máximo alcanzado que generó la alarma
    private Float valor_excedido;

    // Identificador del sensor que generó la alarma
    private Long id_sensor;

    /**
     * Constructor vacío
     */
    public DtoAlarma() {
    }

    /**
     * Constructor que inicializa value_max, dateTime y typeAlarm
     * @param valor_excedido Valor máximo que generó la alarma
     * @param fechaHora_alarma Fecha y hora del evento de la alarma
     * @param tipoAlarmaEnum Tipo de alarma
     */
    public DtoAlarma(Float valor_excedido, LocalDateTime fechaHora_alarma, TipoAlarmaEnum tipoAlarmaEnum) {
        this.valor_excedido = valor_excedido;
        this.fechaHora_alarma = fechaHora_alarma;
        this.tipoAlarmaEnum = tipoAlarmaEnum;
    }

    /**
     * Constructor que inicializa todos los atributos de la alarma
     * @param id_alarma Identificador de la alarma
     * @param tipoAlarmaEnum Tipo de alarma
     * @param fechaHora_alarma Fecha y hora del evento de la alarma
     * @param valor_excedido Valor máximo alcanzado
     * @param id_sensor Identificador del sensor asociado
     */
    public DtoAlarma(Long id_alarma, TipoAlarmaEnum tipoAlarmaEnum, LocalDateTime fechaHora_alarma, Float valor_excedido, Long id_sensor) {
        this.id_alarma = id_alarma;
        this.tipoAlarmaEnum = tipoAlarmaEnum;
        this.fechaHora_alarma = fechaHora_alarma;
        this.valor_excedido = valor_excedido;
        this.id_sensor = id_sensor;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public Long getId_alarma() {
        return id_alarma;
    }

    public void setId_alarma(Long id_alarma) {
        this.id_alarma = id_alarma;
    }

    public TipoAlarmaEnum getTipoAlarmaEnum() {
        return tipoAlarmaEnum;
    }

    public void setTipoAlarmaEnum(TipoAlarmaEnum tipoAlarmaEnum) {
        this.tipoAlarmaEnum = tipoAlarmaEnum;
    }

    public LocalDateTime getFechaHora_alarma() {
        return fechaHora_alarma;
    }

    public void setFechaHora_alarma(LocalDateTime fechaHora_alarma) {
        this.fechaHora_alarma = fechaHora_alarma;
    }

    public Float getValor_excedido() {
        return valor_excedido;
    }

    public void setValor_excedido(Float valor_excedido) {
        this.valor_excedido = valor_excedido;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    /**
     * Método toString()
     * Devuelve una representación en texto del objeto dtoAlarm.
     */
    @Override
    public String toString() {
        return "dtoAlarm{" +
                "id_alarm=" + id_alarma +
                ", typeAlarm=" + tipoAlarmaEnum +
                ", dateTime=" + fechaHora_alarma +
                ", value_max=" + valor_excedido +
                ", id_sensor=" + id_sensor +
                '}';
    }
}

