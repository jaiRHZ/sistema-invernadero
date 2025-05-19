package com.microservice.sensors.service.imp;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.sensors.router.ActionRouter;
import com.microservice.sensors.service.Facade;
import com.microservice.sensors.service.MuestraService;
import com.microservice.sensors.service.SensorService;
import com.mycompany.utilities.dto.MuestraDto;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.exchange.ResponseFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FacadeImp implements Facade {
    private SensorService sensorService;
    private MuestraService muestraService;
    private ObjectMapper objectMapper;

    @Autowired
    public FacadeImp(SensorService sensorService, MuestraService muestraService, ObjectMapper objectMapper) {
        this.sensorService = sensorService;
        this.muestraService = muestraService;
        this.objectMapper = objectMapper;
    }

    @Override
    public MuestraDto createMuestra(MuestraDto muestraDto) {
        return muestraService.createMuestra(muestraDto);
    }

    @Override
    public ResponseFormat readAllMuestra() {
        try {
            List<MuestraDto> muestrasDtos = muestraService.readAllMuestra();
            if (!muestrasDtos.isEmpty() || muestrasDtos != null) {
                return new ResponseFormat(objectMapper.writeValueAsString(muestrasDtos),
                        HttpStatus.OK.value());
            }
            return new ResponseFormat(objectMapper.writeValueAsString("No se puedo consultar las muestras"),
                    HttpStatus.NOT_FOUND.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se puedo puedo consultar las muestras",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseFormat createSensor(SensorDto sensorDto) {
        try {
            sensorDto = sensorService.createSensor(sensorDto);
            if (sensorDto.getId_sensor() != null) {
                return new ResponseFormat(objectMapper.writeValueAsString(sensorDto),
                        HttpStatus.OK.value());
            }
            return new ResponseFormat(objectMapper.writeValueAsString("No se puedo registrar el sensor"),
                    HttpStatus.NOT_FOUND.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se puedo registrar el sensor",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseFormat readAllSensores() {
        try {
            List<SensorDto> sensoresDtos = sensorService.readAllSensores();
            if (!sensoresDtos.isEmpty() || sensoresDtos != null) {
                return new ResponseFormat(objectMapper.writeValueAsString(sensoresDtos),
                        HttpStatus.OK.value());
            }
            return new ResponseFormat(objectMapper.writeValueAsString("No hay registros en la bd de sensores"),
                    HttpStatus.NOT_FOUND.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se puedo puedo consultar los registros",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseFormat readSensorSerie(String serie) {
        try {
            SensorDto sensorDto = sensorService.readSensorSerie(serie);
            if (sensorDto.getId_sensor() != null) {
                return new ResponseFormat(objectMapper.writeValueAsString(sensorDto),
                        HttpStatus.OK.value());
            }
            return new ResponseFormat(objectMapper.writeValueAsString("No existe el sensor en la bd"),
                    HttpStatus.NOT_FOUND.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se puedo buscar el sensor",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
