package com.itson.utilities.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DtoUmbral
 * Representa un umbral asociado a uno o varios sensores.
 * Un umbral define un rango de valores (mínimo y máximo) y una condición para generar alertas.
 */
public class DtoUmbral implements Serializable {

    // Identificador único del umbral
    private Long id_umbral;

    // Condición que se evalúa para activar el umbral (por ejemplo, MAYOR_QUE, MENOR_QUE, ENTRE)
    private CondicionEnum condicionEnum;

    // Valor máximo permitido por el umbral
    private Float max;

    // Valor mínimo permitido por el umbral
    private Float min;

    // Lista de identificadores de sensores a los que aplica este umbral
    private List<Long> ids_sensor_umbral;

    /**
     * Constructor vacío necesario para frameworks de serialización y deserialización.
     */
    public DtoUmbral() {
    }

    /**
     * Constructor básico sin lista de sensores ni ID.
     * @param condicionEnum Condición del umbral
     * @param max Valor máximo
     * @param min Valor mínimo
     */
    public DtoUmbral(CondicionEnum condicionEnum, Float max, Float min) {
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
    }

    /**
     * Constructor que incluye los IDs de los sensores asociados.
     * @param condicionEnum Condición del umbral
     * @param max Valor máximo
     * @param min Valor mínimo
     * @param ids_sensor_umbral Lista de IDs de sensores
     */
    public DtoUmbral(CondicionEnum condicionEnum, Float max, Float min, List<Long> ids_sensor_umbral) {
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    /**
     * Constructor completo con ID del umbral.
     * @param id_umbral ID del umbral
     * @param condicionEnum Condición asociada
     * @param max Valor máximo
     * @param min Valor mínimo
     * @param ids_sensor_umbral Lista de sensores asociados
     */
    public DtoUmbral(Long id_umbral, CondicionEnum condicionEnum, Float max, Float min, List<Long> ids_sensor_umbral) {
        this.id_umbral = id_umbral;
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    // Getters y setters

    public Long getId_umbral() {
        return id_umbral;
    }

    public void setId_umbral(Long id_umbral) {
        this.id_umbral = id_umbral;
    }

    public CondicionEnum getCondicionEnum() {
        return condicionEnum;
    }

    public void setCondicionEnum(CondicionEnum condicionEnum) {
        this.condicionEnum = condicionEnum;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public List<Long> getIds_sensor_umbral() {
        return ids_sensor_umbral;
    }

    public void setIds_sensor_umbral(List<Long> ids_sensor_umbral) {
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    /**
     * Representación en texto del objeto, útil para depuración o logs.
     */
    @Override
    public String toString() {
        return "DtoUmbral{" +
                "id_umbral=" + id_umbral +
                ", condicionEnum=" + condicionEnum +
                ", max=" + max +
                ", min=" + min +
                ", ids_sensor_umbral=" + ids_sensor_umbral +
                '}';
    }
}
