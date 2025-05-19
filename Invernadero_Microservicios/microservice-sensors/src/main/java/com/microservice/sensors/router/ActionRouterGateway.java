package com.microservice.sensors.router;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.sensors.service.Facade;
import com.microservice.sensors.service.SensorService;
import com.mycompany.utilities.dto.MuestraDto;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.formatoGateway.Data;
import com.mycompany.utilities.formatoGateway.MessageFormat;
import com.mycompany.utilities.exchange.RequestFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionRouterGateway {

    private final Map<String, Consumer<String>> actionMap;
    private SensorService sensorService;
    private Facade facade;
    private ObjectMapper objectMapper;

    @Autowired
    public ActionRouterGateway(Facade facade, ObjectMapper objectMapper, SensorService sensorService) {
        actionMap = new HashMap<>();
        this.facade = facade;
        this.objectMapper = objectMapper;
        actionMap.put("create-muestras", this::createMuestras);
        this.sensorService = sensorService;
    }

    private void createMuestras(String content) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            List<MessageFormat> messageFormats = objectMapper.readValue(content, new TypeReference<List<MessageFormat>>() {
            });
            for (MessageFormat messageFormat : messageFormats) {
                SensorDto sensorDto = sensorService.readSensorSerie(messageFormat.getSerie());
                messageFormat.toString();
                if (sensorDto != null) {

                    for (Data data : messageFormat.getData()) {
                        MuestraDto muestraDto = new MuestraDto(
                                data.getType(),
                                data.getMagnitude(),
                                LocalDateTime.parse(messageFormat.getDate(), formatter),
                                data.getValue(),
                                sensorDto.getId_sensor());
                        facade.createMuestra(muestraDto);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void route(RequestFormat requestFormat) {
        String method = requestFormat.getMethod();
        String content = requestFormat.getContent();
        Consumer<String> action = actionMap.get(method);
        if (action != null) {
            action.accept(content);
        }
    }

}
