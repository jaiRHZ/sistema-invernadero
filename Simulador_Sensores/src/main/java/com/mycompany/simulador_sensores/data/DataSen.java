/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.simulador_sensores.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mycompany.simulador_sensores.data.impl.HumidityData;
import com.mycompany.simulador_sensores.data.impl.TemperatureData;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = HumidityData.class, name = "humidity"),
    @JsonSubTypes.Type(value = TemperatureData.class, name = "temperature")
})

/**
 * Interface that defines the methods for taking measurements
 *
 * @author Diego
 */
public interface DataSen {

    /**
     * Method for perform a sensing operation
     */
    public void sense();

}
