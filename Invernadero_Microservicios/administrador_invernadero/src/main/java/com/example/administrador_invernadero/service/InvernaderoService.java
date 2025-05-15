package com.example.administrador_invernadero.service;

import com.itson.utilities.dto.DtoInvernadero;

public interface InvernaderoService {

    DtoInvernadero createInvernadero(DtoInvernadero invernaderoDto);

    DtoInvernadero readInvernadero(Long id);

}
