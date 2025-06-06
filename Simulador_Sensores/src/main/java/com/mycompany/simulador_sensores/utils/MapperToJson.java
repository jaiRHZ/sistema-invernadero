/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.simulador_sensores.sensor.Sensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * * Utility class for converting objects to JSON strings. This class uses
 * Jackson's ObjectMapper to perform the conversion.
 *
 * @author Diego
 */
public class MapperToJson {

    /**
     * Logger for logging messages and errors
     */
    private static final Logger LOGGER = Logger.getLogger(MapperToJson.class.getName());

    /**
     *
     * @param sensor
     * @return
     */
    public static String mapperToJsonSensor(Sensor sensor) {
        try {
            if (sensor == null) {
                throw new IllegalArgumentException("Sensor cannot be null");
            } 

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(sensor);
        } catch (JsonProcessingException ex) {
            LOGGER.log(Level.SEVERE, "Failed to convert sensor to JSON", ex);
        }
        return null;
    }

}
