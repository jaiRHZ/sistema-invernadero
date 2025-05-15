package com.example.administrador_invernadero.service;

import com.itson.utilities.dto.DtoContacto;

public interface ContactoService {

    DtoContacto createContacto(DtoContacto contactoDto);

    DtoContacto readContacto(Long id);
}
