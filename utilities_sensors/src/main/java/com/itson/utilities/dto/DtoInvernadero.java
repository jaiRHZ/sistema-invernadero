package com.itson.utilities.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DtoInvernadero
 * Representa un DTO (Data Transfer Object) que encapsula la información de un invernadero.
 */
public class DtoInvernadero implements Serializable {

    // Identificador único del invernadero
    private Long id_invernadero;

    // Nombre del invernadero
    private String nombre;

    // Ubicación geográfica o dirección del invernadero
    private String localizacion;

    // Descripción general del invernadero
    private String descripcion;

    // Lista de sensores asociados al invernadero
    private List<DtoSensor> sensores;

    // Lista de identificadores de contactos vinculados a este invernadero
    private List<Long> ids_invernadero_contacto;

    /**
     * Constructor vacío requerido para la serialización y frameworks de persistencia.
     */
    public DtoInvernadero() {
    }

    /**
     * Constructor para crear un invernadero sin ID ni sensores ni contactos.
     * @param nombre Nombre del invernadero
     * @param localizacion Ubicación del invernadero
     * @param descripcion Descripción del invernadero
     */
    public DtoInvernadero(String nombre, String localizacion, String descripcion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
    }

    /**
     * Constructor para crear un invernadero con ID y contactos, sin sensores.
     * @param id_invernadero ID del invernadero
     * @param nombre Nombre del invernadero
     * @param localizacion Ubicación
     * @param descripcion Descripción
     * @param ids_invernadero_contacto Lista de IDs de contactos asociados
     */
    public DtoInvernadero(Long id_invernadero, String nombre, String localizacion, String descripcion, List<Long> ids_invernadero_contacto) {
        this.id_invernadero = id_invernadero;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    /**
     * Constructor para crear un invernadero con sensores y contactos, pero sin ID.
     * @param nombre Nombre del invernadero
     * @param localizacion Ubicación
     * @param descripcion Descripción
     * @param sensores Lista de sensores
     * @param ids_invernadero_contacto Lista de IDs de contactos
     */
    public DtoInvernadero(String nombre, String localizacion, String descripcion, List<DtoSensor> sensores, List<Long> ids_invernadero_contacto) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.sensores = sensores;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    /**
     * Constructor completo para inicializar todos los campos de la clase.
     * @param id_invernadero ID del invernadero
     * @param nombre Nombre
     * @param localizacion Ubicación
     * @param descripcion Descripción
     * @param sensores Lista de sensores
     * @param ids_invernadero_contacto Lista de IDs de contactos
     */
    public DtoInvernadero(Long id_invernadero, String nombre, String localizacion, String descripcion, List<DtoSensor> sensores, List<Long> ids_invernadero_contacto) {
        this.id_invernadero = id_invernadero;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.sensores = sensores;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    // Métodos getter y setter

    public Long getId_invernadero() {
        return id_invernadero;
    }

    public void setId_invernadero(Long id_invernadero) {
        this.id_invernadero = id_invernadero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DtoSensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<DtoSensor> sensores) {
        this.sensores = sensores;
    }

    public List<Long> getIds_invernadero_contacto() {
        return ids_invernadero_contacto;
    }

    public void setIds_invernadero_contacto(List<Long> ids_invernadero_contacto) {
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    /**
     * Método toString
     * Devuelve una representación en texto del objeto DtoInvernadero, útil para depuración.
     */
    @Override
    public String toString() {
        return "DtoInvernadero{" +
                "id_invernadero=" + id_invernadero +
                ", nombre='" + nombre + '\'' +
                ", localizacion='" + localizacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", sensores=" + sensores +
                ", ids_invernadero_contacto=" + ids_invernadero_contacto +
                '}';
    }
}
