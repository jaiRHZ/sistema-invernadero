/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author Diego
 */
public class CoapProtocolTest {

    public static void main(String[] args) {
        CoapServer server = new CoapServer();
        CoapResource testResource = new CoapResource("test") {
            @Override
            public void handlePOST(CoapExchange exchange) {
                String requestContent = exchange.getRequestText();
                System.out.println("Received POST request: " + requestContent);
                exchange.respond(CoAP.ResponseCode.CONTENT, "Request received");
            }
        };
        server.add(testResource);
        server.start();
    }

}
