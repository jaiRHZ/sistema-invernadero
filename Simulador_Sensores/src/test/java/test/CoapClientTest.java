/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;

/**
 *
 * @author Diego
 */
public class CoapClientTest {

    public static void main(String[] args) {
        CoapProtocol coapProtocol = CoapProtocol.builder()
                .coapServerUri("coap://localhost:5683/test")
                .build();
        coapProtocol.connect();
        coapProtocol.publish("Test message");
        coapProtocol.disconnect();
    }
}
