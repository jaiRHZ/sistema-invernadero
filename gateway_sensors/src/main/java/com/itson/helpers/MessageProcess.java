package com.itson.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itson.utilities.exchange.RequestFormat;
import com.itson.utilities.gatewayformat.Data;
import com.itson.utilities.gatewayformat.MessageFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageProcess {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static MessageFormat messageFormat(String message) {

        try {
            JsonNode rootNode = mapper.readTree(message);
            String serie = rootNode.get("serie").asText();
            int interval = rootNode.get("timeInterval").asInt();
            String date = rootNode.get("captureData").asText();
            List<Data> data = parseDataNodes(rootNode.get("data"));

            return new MessageFormat(serie, date, data, interval);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error procesando JSON", e);
        }
    }

    private static List<Data> parseDataNodes(JsonNode medicionesNode) {
        List<Data> data = new ArrayList<>();
        if (medicionesNode != null) {
            for (JsonNode medidaNode : medicionesNode) {
                String type = medidaNode.get("type").asText();
                Optional<String> magnitude = getMagnitudeByType(medidaNode, type);
                float value = medidaNode.get("value").floatValue();
                data.add(new Data(type, magnitude.orElse(null), value));
            }
        }
        return data;
    }

    private static Optional<String> getMagnitudeByType(JsonNode medidaNode, String type) {
        if ("temperature".equals(type) && medidaNode.has("temperatureUnit")) {
            return Optional.of(medidaNode.get("temperatureUnit").asText());
        } else if ("humidity".equals(type) && medidaNode.has("humidityUnit")) {
            return Optional.of(medidaNode.get("humidityUnit").asText());
        }
        return Optional.empty();
    }

    public static String constructJsonArray(List<MessageFormat> messages) {
        try {
            String jsonArray = mapper.writeValueAsString(messages);
            RequestFormat requestFormat = new RequestFormat(jsonArray, "create-muestras");
            String json = mapper.writeValueAsString(requestFormat);
            return json;
        } catch (JsonProcessingException e) {
            System.err.println("Error processing json: " + e.getMessage());
            return "[]";
        }
    }
}
