/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.facade.impl;

import com.mycompany.simulador_sensores.dao.SensorDAO;
import com.mycompany.simulador_sensores.dao.iml.SensorDAOImpl;
import com.mycompany.simulador_sensores.facade.SensorFacade;
import com.mycompany.simulador_sensores.sensor.Sensor;
import java.util.List;

/**
 *
 * @author Diego
 */
public class SensorFacadeImpl implements SensorFacade {
    
    private final SensorDAO sensorDAO = SensorDAOImpl.getInstance();
    
    public SensorFacadeImpl() {
    }
    
    @Override
    public void addSensor(Sensor sensor) {
        validateSensor(sensor);
        sensorDAO.addSensor(sensor);
    }
    
    @Override
    public void updateSensor(Sensor sensor) {
        validateSensor(sensor);
        sensorDAO.updateSensor(sensor);
    }
    
    @Override
    public Sensor readSensor(String serie) {
        if (serie == null || serie.isEmpty()) {
            throw new IllegalArgumentException("El campo 'serie' no puede estar vacío o nulo.");
        }
        return sensorDAO.readSensor(serie);
    }
    
    @Override
    public List<Sensor> readAllSensors() {
        return sensorDAO.readAllSensors();
    }
    
    @Override
    public void deleteSensor(String serie) {
        if (serie == null || serie.isEmpty()) {
            throw new IllegalArgumentException("El campo 'serie' no puede estar vacío o nulo.");
        }
        sensorDAO.deleteSensor(serie);
    }
    
    private void validateSensor(Sensor sensor) {
        if (sensor.getSerie() == null || sensor.getSerie().isEmpty()) {
            throw new IllegalArgumentException("El campo 'serie' no puede estar vacío o nulo.");
        }
        if (sensor.getTimeInterval() <= 0) {
            throw new IllegalArgumentException("El intervalo de tiempo debe ser mayor que 0.");
        }
        if (sensor.getProtocol() == null) {
            throw new IllegalArgumentException("El protocolo no puede ser nulo.");
        }
        if (sensor.getData() == null || sensor.getData().isEmpty()) {
            throw new IllegalArgumentException("Las muestras del sensor no pueden ser nulos o vacíos.");
        }
    }
    
}
