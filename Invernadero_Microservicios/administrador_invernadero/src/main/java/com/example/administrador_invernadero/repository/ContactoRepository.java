package com.example.administrador_invernadero.repository;

import com.example.administrador_invernadero.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

}
