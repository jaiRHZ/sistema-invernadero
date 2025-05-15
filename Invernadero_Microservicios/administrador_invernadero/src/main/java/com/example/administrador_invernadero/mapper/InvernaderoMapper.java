package com.example.administrador_invernadero.mapper;


import java.util.List;
import java.util.stream.Collectors;

import com.example.administrador_invernadero.entity.Invernadero;
import com.example.administrador_invernadero.entity.Invernadero_Contacto;
import com.example.administrador_invernadero.repository.Invernadero_ContactoRepository;
import com.itson.utilities.dto.DtoInvernadero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvernaderoMapper {

    @Autowired
    private Invernadero_ContactoRepository invernadero_ContactoRepository;

    public DtoInvernadero mapperToInvernaderoDto(Invernadero invernadero) {

        List<Long> ids_invernadero_contacto = invernadero.getInvernadero_Contactos().stream()
                .map(Invernadero_Contacto::getId_invernadero_contacto)
                .collect(Collectors.toList());

        return new DtoInvernadero(
                invernadero.getId_invernadero(),
                invernadero.getName(),
                invernadero.getLocalizacion(),
                invernadero.getDescripcion(),
                ids_invernadero_contacto);
    }

    public Invernadero mapperToInvernadero(DtoInvernadero invernaderoDto) {
        return new Invernadero(
                invernaderoDto.getId_invernadero(),
                invernaderoDto.getDescripcion(),
                invernaderoDto.getNombre(),
                invernaderoDto.getLocalizacion(),
                invernadero_ContactoRepository.
                        findAllById(invernaderoDto.getIds_invernadero_contacto()));
    }
}
