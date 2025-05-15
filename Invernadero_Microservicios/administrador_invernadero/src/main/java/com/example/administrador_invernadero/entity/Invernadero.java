package com.example.administrador_invernadero.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "invernaderos")
public class Invernadero {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_invernadero;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;

    @Column(name = "localizacion", nullable = false, length = 255)
    private String localizacion;

    @OneToMany(mappedBy = "invernadero")
    private List<Invernadero_Contacto> invernadero_Contactos;

}
