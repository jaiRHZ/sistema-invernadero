package com.itson.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itson.gateway.impl.Gateway;
import lombok.Data;

@Data
public class GatewayDto {

    private String series;
    private int captureTime;
    private boolean status;

    public GatewayDto() {
    }

    public GatewayDto(Gateway gateway) {
        this.series = gateway.getSeries();
        this.captureTime = gateway.getCaptureTime();
        this.status = gateway.isStatus();
    }

    @JsonIgnore
    public Gateway getObjectGateway() {
        Gateway gateway = new Gateway(series, captureTime);
        gateway.setStatus(status);
        return gateway;
    }
}
