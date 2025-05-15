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
@Table(name = "contactos")
public class Contacto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contacto;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "telefono", nullable = false, length = 255)
    private String telefono;

    @OneToMany(mappedBy = "contacto")
    private List<Invernadero_Contacto> invernadero_Contactos;

}
