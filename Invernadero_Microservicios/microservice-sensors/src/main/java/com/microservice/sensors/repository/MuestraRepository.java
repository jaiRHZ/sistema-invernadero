package com.microservice.sensors.repository;

import com.microservice.sensors.entity.Muestra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Long>  {
}
