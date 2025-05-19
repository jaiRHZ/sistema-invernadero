package com.microservice.sensors.controller;


import com.microservice.sensors.service.Facade;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.exchange.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api/sensor")
public class SensorController {

    private final Facade facade;

    @Autowired
    public SensorController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping("/")
    public ResponseFormat readAllSensors() {
        return facade.readAllSensores();
    }

    @PostMapping("/")
    public ResponseFormat createSensor(@RequestBody SensorDto sensorDto) {
        return facade.createSensor(sensorDto);
    }

}
