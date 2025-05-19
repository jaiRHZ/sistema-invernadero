/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol.impl;

import com.mycompany.simulador_sensores.protocol.Protocol;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class that implements the logic for sending messages asynchronously using the
 * Mqtt protocol
 *
 * @author Diego
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MqttProtocol implements Protocol {

    private static final Logger LOGGER = Logger.getLogger(MqttProtocol.class.getName());

    /**
     * MQTT client for handling connection and communication
     */
    @JsonIgnore
    private transient MqttClient client;

    /**
     * URL of the MQTT broker to connect to
     */
    private String broker;

    /**
     * Client ID to use when connecting to the MQTT broker
     */
    private String clientId;

    /**
     * Topic to which messages will be published
     */
    private String topic;

    /**
     * Connects to the Mqtt communication protocol
     */
    @Override
    public void connect() {
        initializeClient();
        if (!client.isConnected()) {
            try {
                MqttConnectOptions connOpts = createConnectionOptions();
                client.connect(connOpts);
                LOGGER.info("Connected to the broker: " + broker);
            } catch (MqttException ex) {
                LOGGER.log(Level.SEVERE, "Failed to connect to the broker: " + broker, ex);
            }
        } else {
            LOGGER.info("Client is already connected");
        }
    }

    /**
     * Disconnects from the Mqtt communication protocol
     */
    @Override
    public void disconnect() {
        try {
            if (this.client != null && this.client.isConnected()) {

                client.disconnect();
                client.close();
                client = null;
                LOGGER.info("Disconnected from the broker");

            } else {
                System.out.println("Cliente MQTT ya está desconectado.");
                LOGGER.warning("El cliente MQTT no está conectado.");
            }
        } catch (MqttException ex) {
            LOGGER.log(Level.SEVERE, "Failed to disconnect from the broker", ex.getMessage());
        }
    }

    /**
     * Publishes a message to the Mqtt protocol
     *
     * @param message message to be published
     */
    @Override
    public void publish(String message) {
        if (client == null || !client.isConnected()) {
            LOGGER.warning("Cannot publish message. Client is not connected.");
            return;
        }

        MqttMessage messageSender = createMqttMessage(message);
        try {

            client.publish(topic, messageSender);
            LOGGER.info("Published message to topic '" + topic + "': " + message);
        } catch (MqttException ex) {
            LOGGER.log(Level.SEVERE, "Failed to publish message to topic: " + topic, ex);
        }
    }

    /**
     * Initializes the MQTT client if it is not already initialized. This method
     * ensures that the client is created with the specified broker, client ID,
     * and persistence.
     */
    private void initializeClient() {
        if (this.client == null) {
            try {
                this.client = new MqttClient(broker, clientId, new MemoryPersistence());
            } catch (MqttException ex) {
                LOGGER.log(Level.SEVERE, "Error initializing MQTT client", ex);
            }
        }
    }

    /**
     * Creates a new MQTT message with the specified payload.
     *
     * @param payload the message payload.
     * @return a configured MqttMessage object.
     */
    private MqttMessage createMqttMessage(String payload) {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(2);
        return message;
    }

    /**
     * Creates and configures MQTT connection options.
     *
     * @return a configured MqttConnectOptions object.
     */
    private MqttConnectOptions createConnectionOptions() {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        return connOpts;
    }

}
