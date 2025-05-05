package com.itson.receiver.factory;

import com.itson.gateway.IGateway;
import com.itson.receiver.IProtocolReceiver;
import com.itson.receiver.impl.ProtocolReceiverCoap;
import com.itson.receiver.impl.ProtocolReceiverMqqt;
import com.itson.sender.IProtocolSender;
import com.itson.sender.impl.ProtocolSenderRabbit;

public class FactoryProtocol {

    public static IProtocolReceiver createProtocolReceiverCoap(String serie,
                                                               IGateway gateway) {
        String broker = "gateway_" + serie;
        return new ProtocolReceiverCoap(broker, gateway);
    }

    public static IProtocolReceiver createProtocolReceiverMqqt(String serie, IGateway gateway) {
        String broker = "tcp://broker.emqx.io:1883";
        String topic = "sensor/" + "gateway_" + serie;
        String clienteId = "gateway_" + serie;
        return new ProtocolReceiverMqqt(broker, clienteId, topic, gateway);
    }

    public static IProtocolSender createProtocolSenderRabbit() {
        return new ProtocolSenderRabbit();
    }

}
