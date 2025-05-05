package com.itson.sender;

public interface IProtocolSender {

    public void connect();

    public void send(String message);

}
