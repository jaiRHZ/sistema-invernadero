package com.microservice.sensors.service.imp;


import com.microservice.sensors.entity.Sensor;
import com.microservice.sensors.mapper.SensorMapper;
import com.microservice.sensors.repository.SensorRepository;
import com.microservice.sensors.service.SensorService;
import com.mycompany.utilities.dto.SensorDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorMapper sensorMapper;

    @Override
    public SensorDto createSensor(SensorDto sensorDto) {
        Sensor sensor = sensorMapper.mapperToSensor(sensorDto);
        sensor = sensorRepository.save(sensor);
        return sensorMapper.mapperToSensorDto(sensor);
    }

    @Override
    public List<SensorDto> readAllSensores() {
        List<Sensor> sensores = sensorRepository.findAll();
        List<SensorDto> sensoresDtos = new ArrayList<>();
        for (Sensor sensor : sensores) {
            sensoresDtos.add(sensorMapper.mapperToSensorDto(sensor));
        }
        return sensoresDtos;
    }

    @Override
    public SensorDto readSensorSerie(String serie) {
        Sensor sensor = sensorRepository.findBySerie(serie);
        return sensorMapper.mapperToSensorDto(sensor);
    }

    @Override
    public Boolean eliminateSensor(SensorDto sensorDto) {
        if (sensorDto.getId_sensor() != null) {
            Sensor sensor = sensorMapper.mapperToSensor(sensorDto);
            sensorRepository.deleteById(sensor.getId_sensor());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SensorDto updateSensor(SensorDto sensorDto) {
        Sensor sensorExistente = sensorRepository.findById(sensorDto.getId_sensor()).orElse(null);
        if (sensorExistente != null) {
            sensorExistente.setLocalizacion(sensorDto.getLocalizacion());
            sensorExistente.setGateway(sensorDto.getGateway());
            sensorExistente.setId_invernadero(sensorDto.getId_invernadero());
            sensorExistente = sensorRepository.save(sensorExistente);
            return sensorMapper.mapperToSensorDto(sensorExistente);
        } else {
            return null;
        }
    }

    @Override
    public SensorDto readSensorId(Long id) {
        Sensor sensorExistente = sensorRepository.findById(id).orElse(null);
        return sensorMapper.mapperToSensorDto(sensorExistente);
    }

}
