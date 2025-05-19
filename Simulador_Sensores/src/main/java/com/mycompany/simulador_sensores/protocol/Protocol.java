/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;
import com.mycompany.simulador_sensores.protocol.impl.MqttProtocol;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CoapProtocol.class, name = "coap"),
    @JsonSubTypes.Type(value = MqttProtocol.class, name = "mqtt")
})
/**
 * Interface that defines methods for using the protocol
 *
 * @author Diego
 */
public interface Protocol {

    /**
     * Connects to the communication protocol
     */
    public void connect();

    /**
     * Disconnects from the communication protocol
     */
    public void disconnect();

    /**
     * Publishes a message to the protocol
     *
     * @param message message to be published
     */
    public void publish(String message);

}
