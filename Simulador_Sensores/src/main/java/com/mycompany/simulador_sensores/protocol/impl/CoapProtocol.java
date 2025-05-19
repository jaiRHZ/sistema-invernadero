/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.simulador_sensores.protocol.Protocol;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;

/**
 * Class that implements the logic for sending messages asynchronously using the
 * Coap protocol
 *
 * @author Diego
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoapProtocol implements Protocol {

    /**
     * Logger for logging messages and errors
     */
    private static final Logger LOGGER = Logger.getLogger(CoapProtocol.class.getName());

    /**
     * CoAP client for handling connection and communication
     */
    @JsonIgnore
    private transient CoapClient client;

    /**
     * URI of the CoAP server to connect to
     */
    private String coapServerUri;

    /**
     * Connects to the Coap communication protocol
     */
    @Override
    public void connect() {
        client = new CoapClient(coapServerUri);
    }

    /**
     * Disconnects from the Coap communication protocol
     */
    @Override
    public void disconnect() {
        if (client != null) {
            client.shutdown();
            client = null;
            LOGGER.info("Disconnected from the CoAP server");
        }
    }

    /**
     * Publishes a message to the CoAP server.
     *
     * @param message the message to be published. Must not be null or empty.
     * @throws IllegalArgumentException if the message is null or empty.
     * @throws CoapPublishException if an error occurs during the publication.
     */
    @Override
    public void publish(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        if (client == null) {
            client = new CoapClient(coapServerUri);
        }

        try {
            CoapResponse response = client.post(message, 0);
            handleResponse(response);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, "Error during the publication of data to CoAP", e);
            throw new RuntimeException("Error during the publication of data to CoAP", e);
        } finally {
            client.shutdown(); // Asegúrate de liberar recursos
        }
    }

    /**
     * Handles the response from the CoAP server.
     *
     * @param response the CoAP response.
     * @throws CoapPublishException if the response indicates a failure.
     */
    private void handleResponse(CoapResponse response) {
        if (response == null) {
            throw new RuntimeException("No response from CoAP server");
        }
        if (!response.isSuccess()) {
            System.err.println("Failed response: " + response.getCode());
            throw new RuntimeException("Error sending data to the CoAP server: " + response.getCode());
        }
    }

}
