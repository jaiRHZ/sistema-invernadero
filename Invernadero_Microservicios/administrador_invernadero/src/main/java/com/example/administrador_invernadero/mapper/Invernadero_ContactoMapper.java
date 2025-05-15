package com.example.administrador_invernadero.mapper;

import com.example.administrador_invernadero.entity.Invernadero_Contacto;
import com.itson.utilities.dto.DtoInvernaderoContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Invernadero_ContactoMapper {

    @Autowired
    private InvernaderoMapper invernaderoMapper;

    @Autowired
    private ContactoMapper contactoMapper;

    public DtoInvernaderoContacto mapperToInvernaderoContactoDto(Invernadero_Contacto invernadero_Contacto) {
        return new DtoInvernaderoContacto(
                invernadero_Contacto.getId_invernadero_contacto(),
                invernaderoMapper.mapperToInvernaderoDto(invernadero_Contacto.getInvernadero()),
                contactoMapper.mapperToContactoDto(invernadero_Contacto.getContacto()));
    }

    public Invernadero_Contacto mapperToInvernadero_Contacto(DtoInvernaderoContacto invernaderoContactoDto) {
        return new Invernadero_Contacto(
                invernaderoContactoDto.getId_invernadero_contacto(),
                contactoMapper.mapperToContacto(invernaderoContactoDto.getDtoContacto()),
                invernaderoMapper.mapperToInvernadero(invernaderoContactoDto.getDtoInvernadero()));

    }
}
