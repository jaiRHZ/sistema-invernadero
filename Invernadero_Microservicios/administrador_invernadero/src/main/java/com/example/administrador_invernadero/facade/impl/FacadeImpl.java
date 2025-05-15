package com.example.administrador_invernadero.facade.impl;

import com.example.administrador_invernadero.facade.Facade;
import com.example.administrador_invernadero.service.ContactoService;
import com.example.administrador_invernadero.service.InvernaderoService;
import com.example.administrador_invernadero.service.Invernadero_ContactoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itson.utilities.dto.DtoContacto;
import com.itson.utilities.dto.DtoInvernadero;
import com.itson.utilities.dto.DtoInvernaderoContacto;
import com.itson.utilities.exchange.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacadeImpl implements Facade {
    private ContactoService contactoService;
    private InvernaderoService invernaderoService;
    private Invernadero_ContactoService invernadero_ContactoService;
    private ObjectMapper objectMapper;

    @Autowired
    public FacadeImpl(ContactoService contactoService, InvernaderoService invernaderoService, Invernadero_ContactoService invernadero_ContactoService, ObjectMapper objectMapper) {
        this.contactoService = contactoService;
        this.invernaderoService = invernaderoService;
        this.invernadero_ContactoService = invernadero_ContactoService;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseFormat createContacto(DtoContacto contactoDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseFormat readContacto(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseFormat createInvernadero(DtoInvernadero invernaderoDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseFormat readInvernadero(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseFormat createInvernaderoContacto(DtoInvernaderoContacto invernaderoContactoDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseFormat readInvernaderoContacto(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
