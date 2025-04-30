package com.itson.utilities.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DtoContacto
 * Representa un objeto de transferencia de datos (DTO) que contiene información de un contacto asociado a uno o más invernaderos.
 */
public class DtoContacto implements Serializable {

    // Identificador único del contacto
    private Long id_contacto;

    // Nombre del contacto
    private String nombre;

    // Número telefónico del contacto
    private String numero_telefonico;

    // Correo electrónico del contacto
    private String email;

    // Lista de identificadores de invernaderos asociados al contacto
    private List<Long> ids_invernadero_contacto;

    /**
     * Constructor vacío necesario para frameworks de serialización/deserialización.
     */
    public DtoContacto() {
    }

    /**
     * Constructor para crear un contacto sin ID ni lista de invernaderos (por ejemplo, para creación inicial).
     * @param nombre Nombre del contacto
     * @param numero_telefonico Número telefónico
     * @param email Correo electrónico
     */
    public DtoContacto(String nombre, String numero_telefonico, String email) {
        this.nombre = nombre;
        this.numero_telefonico = numero_telefonico;
        this.email = email;
    }

    /**
     * Constructor para inicializar todos los atributos del contacto.
     * @param id_contacto ID del contacto
     * @param nombre Nombre del contacto
     * @param numero_telefonico Número telefónico
     * @param email Correo electrónico
     * @param ids_invernadero_contacto Lista de IDs de invernaderos asociados
     */
    public DtoContacto(Long id_contacto, String nombre, String numero_telefonico, String email, List<Long> ids_invernadero_contacto) {
        this.id_contacto = id_contacto;
        this.nombre = nombre;
        this.numero_telefonico = numero_telefonico;
        this.email = email;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public Long getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(Long id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getIds_invernadero_contacto() {
        return ids_invernadero_contacto;
    }

    public void setIds_invernadero_contacto(List<Long> ids_invernadero_contacto) {
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    /**
     * Método toString
     * Devuelve una representación en texto del objeto DtoContacto.
     */
    @Override
    public String toString() {
        return "DtoContacto{" +
                "id_contacto=" + id_contacto +
                ", nombre='" + nombre + '\'' +
                ", numero_telefonico='" + numero_telefonico + '\'' +
                ", email='" + email + '\'' +
                ", ids_invernadero_contacto=" + ids_invernadero_contacto +
                '}';
    }
}
