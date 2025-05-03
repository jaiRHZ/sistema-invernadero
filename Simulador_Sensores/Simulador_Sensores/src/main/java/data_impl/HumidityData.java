/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_impl;

import data.Data_Sensores;
import data_impl_unit.HumidityUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that defines the humidity for sensors
 *
 * @author Juan Diego Sánchez
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HumidityData implements Data_Sensores {

    private float value;
    private HumidityUnit humidityUnit;

    /**
     * Method for sensing data
     */
    @Override
    public void sense() {
        int min = 30;
        int max = 90;
        this.value = (float) (min + Math.random() * (max - min));
    }

}
