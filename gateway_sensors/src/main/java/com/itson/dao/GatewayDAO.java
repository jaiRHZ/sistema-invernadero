package com.itson.dao;

import com.itson.gateway.impl.Gateway;

import java.util.List;

public interface GatewayDAO {

    public void addGateway(Gateway gateway);

    public void updateGateway(Gateway gateway);

    public Gateway readGateway(String serie);

    public List<Gateway> readAllGateways();

    public void deleteGateway(String serie);

}
