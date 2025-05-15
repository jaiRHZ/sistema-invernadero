/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import data_impl.HumidityData;
import data_impl.TemperatureData;

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
 * @author Juan Diego Sánchez
 */
public interface Data_Sensores {

    /**
     * Method for perform a sensing operation
     */
    public void sense();

}
