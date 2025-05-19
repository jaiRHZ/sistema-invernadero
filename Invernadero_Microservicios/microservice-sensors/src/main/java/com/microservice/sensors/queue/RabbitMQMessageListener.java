package com.microservice.sensors.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.sensors.router.ActionRouter;
import com.microservice.sensors.router.ActionRouterGateway;
import com.mycompany.utilities.exchange.RequestFormat;
import com.mycompany.utilities.exchange.ResponseFormat;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageListener {

    private ActionRouterGateway actionRouterGateway;
    private ActionRouter actionRouter;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public RabbitMQMessageListener(ActionRouterGateway actionRouterGateway, RabbitTemplate rabbitTemplate,
                                   ActionRouter actionRouter) {
        this.actionRouter = actionRouter;
        this.actionRouterGateway = actionRouterGateway;
    }

    @RabbitListener(queues = "${fanout.queue}")
    public void receiveMessage(String content) throws JsonProcessingException {

        RequestFormat request = objectMapper.readValue(content, RequestFormat.class);
        System.out.println("--Recibiendo información del gateway de sensores");
        actionRouterGateway.route(request);
    }

    @RabbitListener(queues = {"${rabbitmq.sensor.queue.name}"})
    public ResponseFormat consume(@Payload RequestFormat request) throws Exception {
        ResponseFormat responseFormat = new ResponseFormat();
        try {
            responseFormat = actionRouter.route(request);
        } catch (Exception ex) {
            responseFormat.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseFormat.setContent(ex.getMessage());
        }
        return responseFormat;
    }
}
