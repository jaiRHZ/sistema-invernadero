package com.itson.receiver.impl;

import com.itson.gateway.IGateway;
import com.itson.receiver.IProtocolReceiver;
import com.itson.receiver.impl.protocolcoap.ServerCoap;
import com.itson.helpers.MessageProcess;
import com.itson.utilities.gatewayformat.MessageFormat;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class ProtocolReceiverCoap implements IProtocolReceiver {

    private final CoapServer coapServer = ServerCoap.getInstance();
    private final String resource;
    private IGateway gateway;

    public ProtocolReceiverCoap(String resource, IGateway gateway) {
        this.resource = resource;
        this.gateway = gateway;
    }

    @Override
    public void subscribe() {
        coapServer.add(new CoapResource(resource) {
            @Override
            public void handlePOST(CoapExchange exchange) {
                String payload = exchange.getRequestText();
                System.out.println("Mensaje recibido del sensor: " + payload);
                processMessage(payload);
                exchange.respond(CoAP.ResponseCode.CONTENT, "Request received");
            }
        });
    }

    @Override
    public void connect() {
        ServerCoap.connect(this);
        System.out.println("Servidor CoAP encendido");
    }

    @Override
    public void desconnect() {
        coapServer.remove(new CoapResource(resource));
        ServerCoap.desconnect(this);
    }

    private void processMessage(String message) {
        MessageFormat processMessage = MessageProcess.messageFormat(message);
        gateway.processMessage(processMessage);
    }
}
