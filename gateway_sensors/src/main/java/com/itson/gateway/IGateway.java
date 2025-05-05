package com.itson.gateway;

import com.itson.helpers.MessageProcess;
import com.itson.utilities.gatewayformat.MessageFormat;


public interface IGateway {

    public void processMessage(MessageFormat message);

}
