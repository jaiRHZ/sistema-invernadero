package com.example.administrador_invernadero.mapper;

import com.example.administrador_invernadero.entity.Contacto;
import com.example.administrador_invernadero.entity.Invernadero_Contacto;
import com.example.administrador_invernadero.repository.Invernadero_ContactoRepository;
import com.itson.utilities.dto.DtoContacto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactoMapper {

    @Autowired
    private Invernadero_ContactoRepository invernadero_ContactoRepository;

    public DtoContacto mapperToContactoDto(Contacto contacto) {

        List<Long> ids_invernadero_contacto = contacto.getInvernadero_Contactos().stream()
                .map(Invernadero_Contacto::getId_invernadero_contacto)
                .collect(Collectors.toList());

        return new DtoContacto(
                contacto.getId_contacto(),
                contacto.getNombre(),
                contacto.getTelefono(),
                contacto.getEmail(),
                ids_invernadero_contacto);
    }

    public Contacto mapperToContacto(DtoContacto contactoDto) {
        return new Contacto(
                contactoDto.getId_contacto(),
                contactoDto.getNombre(),
                contactoDto.getEmail(),
                contactoDto.getNumero_telefonico(),
                invernadero_ContactoRepository.
                        findAllById(contactoDto.getIds_invernadero_contacto()));
    }

}