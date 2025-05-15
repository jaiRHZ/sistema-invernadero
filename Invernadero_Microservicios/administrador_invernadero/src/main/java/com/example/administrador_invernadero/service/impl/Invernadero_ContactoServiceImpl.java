package com.example.administrador_invernadero.service.impl;

import com.example.administrador_invernadero.entity.Invernadero_Contacto;
import com.example.administrador_invernadero.mapper.Invernadero_ContactoMapper;
import com.example.administrador_invernadero.repository.Invernadero_ContactoRepository;
import com.example.administrador_invernadero.service.Invernadero_ContactoService;
import com.itson.utilities.dto.DtoInvernaderoContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Invernadero_ContactoServiceImpl implements Invernadero_ContactoService {
    @Autowired
    private Invernadero_ContactoRepository invernaderoContactoRepository;

    @Autowired
    private Invernadero_ContactoMapper invernadero_ContactoMapper;

    @Override
    public DtoInvernaderoContacto createInvernaderoContacto(DtoInvernaderoContacto invernaderoContactoDto) {
        Invernadero_Contacto invernadero_Contacto = invernadero_ContactoMapper.mapperToInvernadero_Contacto(invernaderoContactoDto);
        invernadero_Contacto = invernaderoContactoRepository.save(invernadero_Contacto);
        return invernadero_ContactoMapper.mapperToInvernaderoContactoDto(invernadero_Contacto);
    }

    @Override
    public DtoInvernaderoContacto readInvernaderoContacto(Long id) {
        Invernadero_Contacto invernadero_Contacto = invernaderoContactoRepository.findById(id).orElse(null);
        return invernadero_ContactoMapper.mapperToInvernaderoContactoDto(invernadero_Contacto);
    }

}
