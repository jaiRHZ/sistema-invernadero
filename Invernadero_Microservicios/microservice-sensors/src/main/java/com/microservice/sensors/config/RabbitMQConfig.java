package com.microservice.sensors.config;

import java.util.List;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitMQConfig {


    @Value("${fanout.queue}")
    private String queue;

    @Value("${fanout.exchange}")
    private String exchange;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeServicios;

    @Value("${rabbitmq.sensor.queue.name}")
    private String queueSenor;

    @Value("${rabbitmq.sensor.routing.key}")
    private String routingKeySensor;

    @Value("${rabbitmq.invernadero.queue.name}")
    private String queueInvernadero;

    @Value("${rabbitmq.invernadero.routing.key}")
    private String routingKeyInvernadero;

    @Value("${rabbitmq.alarma.queue.name}")
    private String queueAlarma;

    @Value("${rabbitmq.alarma.routing.key}")
    private String routingKeyAlarma;

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeServicios);
    }

    @Bean
    public Queue sensorQueue() {
        return new Queue(queueSenor);
    }

    @Bean
    public Queue invernaderoQueue() {
        return new Queue(queueInvernadero);
    }

    @Bean
    public Queue alarmaQueue() {
        return new Queue(queueAlarma);
    }

    @Bean
    public Binding sensorBinding() {
        return BindingBuilder.bind(sensorQueue())
                .to(exchange())
                .with(routingKeySensor);
    }

    @Bean
    public Binding invernaderoBinding() {
        return BindingBuilder.bind(invernaderoQueue())
                .to(exchange())
                .with(routingKeyInvernadero);
    }

    @Bean
    public Binding alarmaBinding() {
        return BindingBuilder.bind(alarmaQueue())
                .to(exchange())
                .with(routingKeyAlarma);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(queue, true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("com.mycompany.utilities.dto.*",
                "com.mycompany.utilities.intercambio.*",
                "com.mycompany.utilities.formatoGateway.*"));
        return converter;
    }
}
