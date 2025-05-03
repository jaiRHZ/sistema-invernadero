/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package protocol_factory;

import protocol.Protocol;
import protocol_impl.CoapProtocol;
import protocol_impl.MqttProtocol;

/**
 *
 * @author Juan Diego Sánchez
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
