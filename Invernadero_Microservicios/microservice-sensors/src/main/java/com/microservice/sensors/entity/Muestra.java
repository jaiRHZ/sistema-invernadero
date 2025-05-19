package com.microservice.sensors.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "muestras")
public class Muestra {
    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_muestra;

    @Column(name = "tipo", nullable = false, length = 255)
    private String tipo;

    @Column(name = "magnitud", nullable = false, length = 255)
    private String magnitud;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "valor", nullable = false)
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "id_sensor")
    private Sensor sensor;
}
