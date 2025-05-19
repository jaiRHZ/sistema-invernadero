/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor;

import com.mycompany.simulador_sensores.data.DataSen;
import com.mycompany.simulador_sensores.protocol.Protocol;
import com.mycompany.simulador_sensores.utils.MapperToJson;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class abstract that models the behavior of sensors. This class serves as a
 * base for defining various types of sensors.
 *
 * @author Diego
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    /**
     * Series number associated with the sensor
     */
    private String serie;

    /**
     * Time interval (in seconds) at which the sensor sends data
     */
    private int timeInterval;

    /**
     * Current status of the sensor (true if active, false otherwise)
     */
    private volatile boolean status;

    /**
     * Protocol used for communication by the sensor
     */
    private Protocol protocol;

    /**
     * Data interface used by the sensor to capture measurements
     */
    private List<DataSen> data;

    /**
     * Data when sensor data was captured
     */
    private String captureData;

    @JsonIgnore
    private transient ScheduledExecutorService scheduler;
    private static final Logger LOGGER = Logger.getLogger(Sensor.class.getName());

    /**
     * Starts the sensor operation. This method is used to initialize and begin
     * the sensor's data collection process.
     */
    public synchronized void startSensor() {
        if (isSensorRunning()) {
            LOGGER.info("The sensor is already running");
            return;
        }

        if (scheduler == null) {
            status = true;
            protocol.connect();
            scheduler = Executors.newScheduledThreadPool(1);
            System.out.println("Scheduler initialized.");
            startDataCollection();
        } else {
            System.out.println("Scheduler is already running.");
        }

    }

    /**
     * Stops the sensor operation. This method is used to halt the sensor's data
     * collection process and perform any necessary cleanup.
     */
    public synchronized void stopSensor() {
        LOGGER.info("Stopping the sensor...");
        if (!status) {
            LOGGER.info("The sensor is not already running");
            return;
        }

        status = false; // Cambia el estado antes de detener el scheduler
        try {
            if (scheduler != null) {
                scheduler.shutdown(); // Detiene la recepción de nuevas tareas
                try {
                    if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                        scheduler.shutdownNow(); // Forzar el apagado
                    }
                    System.out.println("Sensor detenido correctamente.");
                } catch (InterruptedException e) {
                    scheduler.shutdownNow(); // Forzar el apagado si se interrumpe
                    Thread.currentThread().interrupt(); // Restaura el estado de interrupción
                }
            } else {
                LOGGER.warning("El scheduler ya estaba nulo.");
            }

            protocol.disconnect(); // Desconectar el protocolo
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error during disconnection", ex);
        } finally {
            scheduler = null; // Asegúrate de poner a null después de apagarlo
        }
    }

    private void takeData() {
        for (DataSen dataImp : data) {
            dataImp.sense();
        }
        dateFormat();
    }

    private boolean isSensorRunning() {
        return status;
    }

    private void startDataCollection() {
        try {
            Runnable metodo = () -> {
                if (!status) {
                    return;
                }
                takeData();
                publishData();

            };
            if (scheduler != null && !scheduler.isShutdown()) {
                scheduler.scheduleAtFixedRate(metodo, 0, timeInterval, TimeUnit.SECONDS);
            }
        } catch (Exception ex) {
            status = false;
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void publishData() {
        try {
            if (status) {
                protocol.publish(MapperToJson.mapperToJsonSensor(this));
                System.out.println(this.toString());
            }

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }

    private void dateFormat() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String FormattedDateTime = currentDateTime.format(format);
        captureData = FormattedDateTime;
    }

}
