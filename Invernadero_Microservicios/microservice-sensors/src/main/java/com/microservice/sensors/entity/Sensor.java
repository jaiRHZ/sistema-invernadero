package com.microservice.sensors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sensores")

public class Sensor {
    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sensor;

    @Column(name = "serie", nullable = false, unique = true, length = 255)
    private String serie;

    @Column(name = "localizacion", nullable = false, length = 255)
    private String localizacion;

    @Column(name = "protocolo", nullable = false, length = 100)
    private String protocolo;

    @Column(name = "gateway", nullable = false, length = 100)
    private String gateway;

    @Column(name = "id_invernadero", nullable = false)
    private Long id_invernadero;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sensor")
    private List<Muestra> muestras;

}
