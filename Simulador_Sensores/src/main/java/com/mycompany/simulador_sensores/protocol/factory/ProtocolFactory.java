/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol.factory;

import com.mycompany.simulador_sensores.protocol.Protocol;
import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;
import com.mycompany.simulador_sensores.protocol.impl.MqttProtocol;

/**
 *
 * @author Diego
 */
public class ProtocolFactory {

    public static Protocol createProtocol(String type, String serie, String gateway) {
        switch (type) {
            case "MQTT" -> {
                String broker = "tcp://broker.emqx.io:1883";
                String topic = "sensor/" + "gateway_" + gateway;
                return (Protocol) MqttProtocol.builder().broker(broker).
                        clientId("sensor_" + serie).topic(topic).build();
            }
            case "COAP" -> {
                String coapServerUri = "coap://localhost:5683/" + "gateway_" + gateway;
                return (Protocol) CoapProtocol.builder().coapServerUri(coapServerUri).build();
            }
            default ->
                throw new IllegalArgumentException("Tipo de protocolo no soportado: " + type);
        }
    }
}
