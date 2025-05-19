package com.microservice.sensors.service;

import com.mycompany.utilities.dto.SensorDto;

import java.util.List;

public interface SensorService {

    SensorDto createSensor(SensorDto sensorDto);

    List<SensorDto> readAllSensores();

    SensorDto readSensorSerie(String serie);

    SensorDto readSensorId(Long id);

    Boolean eliminateSensor(SensorDto sensorDto);

    SensorDto updateSensor(SensorDto sensorDto);
}
