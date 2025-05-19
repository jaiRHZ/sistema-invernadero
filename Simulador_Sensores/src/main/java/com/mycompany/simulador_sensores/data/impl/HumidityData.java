/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.data.impl;

import com.mycompany.simulador_sensores.data.DataSen;
import com.mycompany.simulador_sensores.data.impl.unit.HumidityUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that defines the humidity for sensors
 *
 * @author Diego
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HumidityData implements DataSen {

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
