package com.example.administrador_invernadero.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invernadero_contacto")
public class Invernadero_Contacto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_invernadero_contacto;

    @ManyToOne
    @JoinColumn(name = "contacto_id")
    private Contacto contacto;

    @ManyToOne
    @JoinColumn(name = "invernadero_id")
    private Invernadero invernadero;

}
