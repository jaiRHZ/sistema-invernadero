package com.example.administrador_invernadero.service;

import com.itson.utilities.dto.DtoInvernaderoContacto;

public interface Invernadero_ContactoService {

    DtoInvernaderoContacto createInvernaderoContacto(DtoInvernaderoContacto invernaderoContactoDto);

    DtoInvernaderoContacto readInvernaderoContacto(Long id);

}
