package com.itson.receiver.impl;

import com.itson.gateway.IGateway;
import com.itson.helpers.MessageProcess;
import com.itson.receiver.IProtocolReceiver;
import com.itson.utilities.gatewayformat.MessageFormat;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProtocolReceiverMqqt implements IProtocolReceiver {

    private transient MqttClient client;
    private final String broker;
    private final String clientId;
    private final String topic;
    private final IGateway gateway;

    public ProtocolReceiverMqqt(String broker, String clientId, String topic, IGateway gateway) {
        this.broker = broker;
        this.clientId = clientId;
        this.topic = topic;
        this.gateway = gateway;
    }

    @Override
    public void subscribe() {
        try {
            client.subscribe(topic);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexión perdida con el broker");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String messageReceiver = new String(message.getPayload());
                    MessageFormat format = processMessage(messageReceiver);
                    System.out.println("Mensaje recibido del tema '" + topic
                            + "': " + format);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("Entrega completa");
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect() {
        try {
            client = new MqttClient(broker, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
            System.out.println("Conectado al broker: " + broker);
        } catch (MqttException ex) {
            System.err.println("Error al conectarse al broker: " + ex.getMessage());
            Logger.getLogger(ProtocolReceiverMqqt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desconnect() {
        if (client != null && client.isConnected()) {
            try {
                client.disconnect();
                System.out.println("Desconectado del broker");
            } catch (MqttException ex) {
                Logger.getLogger(ProtocolReceiverMqqt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private MessageFormat processMessage(String message) {
        MessageFormat proccesMessage = MessageProcess.messageFormat(message);
        gateway.processMessage(proccesMessage);
        return proccesMessage;
    }
}
