package com.example.administrador_invernadero.service.impl;

import com.example.administrador_invernadero.entity.Invernadero;
import com.example.administrador_invernadero.mapper.InvernaderoMapper;
import com.example.administrador_invernadero.repository.InvernaderoRepository;
import com.example.administrador_invernadero.service.InvernaderoService;
import com.itson.utilities.dto.DtoInvernadero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvernaderoServiceImpl implements InvernaderoService {
    @Autowired
    private InvernaderoRepository invernaderoRepository;

    @Autowired
    private InvernaderoMapper invernaderoMapper;

    @Override
    public DtoInvernadero createInvernadero(DtoInvernadero invernaderoDto) {
        Invernadero invernadero = invernaderoMapper.mapperToInvernadero(invernaderoDto);
        invernadero = invernaderoRepository.save(invernadero);
        return invernaderoMapper.mapperToInvernaderoDto(invernadero);
    }

    @Override
    public DtoInvernadero readInvernadero(Long id) {
        Invernadero invernadero = invernaderoRepository.findById(id).orElse(null);
        return invernaderoMapper.mapperToInvernaderoDto(invernadero);
    }

}
