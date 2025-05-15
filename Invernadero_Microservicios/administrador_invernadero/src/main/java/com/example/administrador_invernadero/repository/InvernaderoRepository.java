package com.example.administrador_invernadero.repository;

import com.example.administrador_invernadero.entity.Invernadero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvernaderoRepository extends JpaRepository<Invernadero, Long> {
}
