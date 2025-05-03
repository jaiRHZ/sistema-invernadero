/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_impl;


import data.Data_Sensores;
import data_impl_unit.TemperatureUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that defines the temperature for sensors
 *
 * @author Juan Diego Sánchez
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureData implements Data_Sensores {

    private float value;
    private TemperatureUnit temperatureUnit;

    /**
     * Method for sensing data
     */
    @Override
    public void sense() {
        int min = 10;
        int max = 30;
        this.value = (float) (min + Math.random() * (max - min));
    }

}