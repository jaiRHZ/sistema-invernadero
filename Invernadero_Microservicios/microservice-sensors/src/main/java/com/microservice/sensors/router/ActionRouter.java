package com.microservice.sensors.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.sensors.service.Facade;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.exchange.RequestFormat;
import com.mycompany.utilities.exchange.ResponseFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ActionRouter {
    private final Map<String, Function<String, ResponseFormat>> actionMap;

    private Facade facade;

    private ObjectMapper objectMapper;

    @Autowired
    public ActionRouter(Facade facade, ObjectMapper objectMapper) {
        this.facade = facade;
        this.objectMapper = objectMapper;
        actionMap = new HashMap<>();
        inicializarRouter();
    }

    private void inicializarRouter() {
        actionMap.put("create-sensor", this::createSensor);
        actionMap.put("read-all-muestras", this::readAllMuestra);
        actionMap.put("read-sensor-serie", this::readSensorSerie);
    }

    private ResponseFormat readAllMuestra(String content) {
        return facade.readAllMuestra();
    }

    private ResponseFormat readSensorSerie(String content) {
        try {
            SensorDto sensorDto = objectMapper.readValue(content, SensorDto.class);
            return facade.readSensorSerie(sensorDto.getSerie());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ResponseFormat createSensor(String content) {
        try {
            SensorDto sensorDto = objectMapper.readValue(content, SensorDto.class);
            return facade.createSensor(sensorDto);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResponseFormat route(RequestFormat requestFormat) {
        String method = requestFormat.getMethod();
        String content = requestFormat.getContent();
        return actionMap.getOrDefault(method, this::defaultAction).apply(content);
    }

    private ResponseFormat defaultAction(String payload) {
        return new ResponseFormat("Acción no reconocida",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
