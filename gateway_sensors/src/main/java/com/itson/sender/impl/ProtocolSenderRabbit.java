package com.itson.sender.impl;

import com.itson.sender.IProtocolSender;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProtocolSenderRabbit implements IProtocolSender {

    private static final String HOST = "localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String exchange = "servidor_invernadero";
    private ConnectionFactory factory;

    public ProtocolSenderRabbit() {
    }

    @Override
    public void connect() {
        factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
    }

    @Override
    public void send(String message) {
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // Declara el exchange como fanout
            channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT, true);

            channel.basicPublish(exchange, "", null, message.getBytes("UTF-8"));
            System.out.println("Mensaje enviado al exchange fanout: " + message);

        } catch (Exception e) {
            System.err.println("Error al enviar mensaje: " + e.getMessage());
        }
    }
}
