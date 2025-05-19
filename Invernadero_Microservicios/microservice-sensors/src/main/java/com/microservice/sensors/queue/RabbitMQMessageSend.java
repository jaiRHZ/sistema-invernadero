package com.microservice.sensors.queue;

import com.mycompany.utilities.exchange.RequestFormat;
import com.mycompany.utilities.exchange.ResponseFormat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageSend {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.invernadero.routing.key}")
    private String invernaderoRoutingKey;

    @Value("${rabbitmq.alarma.routing.key}")
    private String alarmaRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public ResponseFormat sendMessageInvernadero(RequestFormat request) {
        try {
            return (ResponseFormat) rabbitTemplate.convertSendAndReceive(exchange, invernaderoRoutingKey, request);

        } catch (Exception e) {
            return null;
        }
    }

    public ResponseFormat sendMessageAlarma(RequestFormat request) {
        try {
            return (ResponseFormat) rabbitTemplate.convertSendAndReceive(exchange, alarmaRoutingKey, request);

        } catch (Exception e) {
            return null;
        }
    }
}
