/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.simulador_sensores.dao;

import com.mycompany.simulador_sensores.sensor.Sensor;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface SensorDAO {

    public void addSensor(Sensor sensor);

    public void updateSensor(Sensor sensor);

    public Sensor readSensor(String serie);

    public List<Sensor> readAllSensors();

    public void deleteSensor(String serie);
}
