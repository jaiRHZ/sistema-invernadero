package com.example.administrador_invernadero.service.impl;

import com.example.administrador_invernadero.entity.Contacto;
import com.example.administrador_invernadero.mapper.ContactoMapper;
import com.example.administrador_invernadero.repository.ContactoRepository;
import com.example.administrador_invernadero.service.ContactoService;
import com.itson.utilities.dto.DtoContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImpl implements ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private ContactoMapper contactoMapper;

    @Override
    public DtoContacto createContacto(DtoContacto contactoDto) {
        Contacto contacto = contactoMapper.mapperToContacto(contactoDto);
        contacto = contactoRepository.save(contacto);
        return contactoMapper.mapperToContactoDto(contacto);
    }

    @Override
    public DtoContacto readContacto(Long id) {
        Contacto contacto = contactoRepository.findById(id).orElse(null);
        return contactoMapper.mapperToContactoDto(contacto);
    }
}
