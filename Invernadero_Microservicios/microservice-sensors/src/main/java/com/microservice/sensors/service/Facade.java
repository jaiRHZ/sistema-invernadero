package com.microservice.sensors.service;

import com.mycompany.utilities.dto.MuestraDto;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.exchange.ResponseFormat;

public interface Facade {
    MuestraDto createMuestra(MuestraDto muestraDto);

    ResponseFormat readAllMuestra();

    ResponseFormat createSensor(SensorDto sensorDto);

    ResponseFormat readSensorSerie(String serie);

    ResponseFormat readAllSensores();
}
