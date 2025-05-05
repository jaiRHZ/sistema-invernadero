package com.itson.receiver.impl.protocolcoap;

import com.itson.receiver.impl.ProtocolReceiverCoap;
import org.eclipse.californium.core.CoapServer;

import java.util.ArrayList;
import java.util.List;

public class ServerCoap {

    private static CoapServer coapServer;
    private static List<ProtocolReceiverCoap> coaps = new ArrayList<>();

    public static synchronized CoapServer getInstance() {
        if (coapServer == null) {
            coapServer = new CoapServer();

        }
        return coapServer;
    }

    public static void connect(ProtocolReceiverCoap coap) {
        coaps.add(coap);
        if (coaps.size() == 1) {
            coapServer.start();
        }
    }

    public static void desconnect(ProtocolReceiverCoap coap) {
        try {
            if (!coaps.isEmpty()) {
                coaps.remove(coap);
            }
            if (coaps.isEmpty() && coapServer != null) {
                coapServer.stop();
                System.out.println("Servidor CoAP detenido");
            }

        } catch (Exception e) {
            System.err.println("Error al detener el servidor CoAP: " + e.getMessage());
        }
    }

}
