package com.example.administrador_invernadero.facade;

import com.itson.utilities.dto.DtoContacto;
import com.itson.utilities.dto.DtoInvernadero;
import com.itson.utilities.dto.DtoInvernaderoContacto;
import com.itson.utilities.exchange.ResponseFormat;

public interface Facade {

    ResponseFormat createContacto(DtoContacto contactoDto);

    ResponseFormat readContacto(Long id);

    ResponseFormat createInvernadero(DtoInvernadero invernaderoDto);

    ResponseFormat readInvernadero(Long id);

    ResponseFormat createInvernaderoContacto(DtoInvernaderoContacto invernaderoContactoDto);

    ResponseFormat readInvernaderoContacto(Long id);

}
