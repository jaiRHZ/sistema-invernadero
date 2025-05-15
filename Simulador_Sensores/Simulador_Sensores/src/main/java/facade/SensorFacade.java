/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import java.util.List;
import sensor.Sensor;

/**
 *
 * @author Juan Diego Sánchez
 */
public interface SensorFacade {

    public void addSensor(Sensor sensor);

    public void updateSensor(Sensor sensor);

    public Sensor readSensor(String serie);

    public List<Sensor> readAllSensors();

    public void deleteSensor(String serie);

}
