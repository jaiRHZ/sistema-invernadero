// Paquete donde se encuentra la clase
package com.itson.utilities.dto;

import java.io.Serializable;

/**
 * Clase DtoInvernaderoContacto
 * Representa la relación entre un invernadero y un contacto.
 * Es útil para modelar una relación muchos-a-muchos con información adicional si se desea.
 */
public class DtoInvernaderoContacto implements Serializable {

    // Identificador único de la relación entre invernadero y contacto
    private Long id_invernadero_contacto;

    // Objeto que representa el invernadero asociado
    private DtoInvernadero dtoInvernadero;

    // Objeto que representa el contacto asociado
    private DtoContacto dtoContacto;

    /**
     * Constructor vacío, necesario para frameworks de serialización o persistencia.
     */
    public DtoInvernaderoContacto() {
    }

    /**
     * Constructor para crear una relación sin ID.
     * @param dtoInvernadero Objeto invernadero asociado
     * @param dtoContacto Objeto contacto asociado
     */
    public DtoInvernaderoContacto(DtoInvernadero dtoInvernadero, DtoContacto dtoContacto) {
        this.dtoInvernadero = dtoInvernadero;
        this.dtoContacto = dtoContacto;
    }

    /**
     * Constructor completo para inicializar todos los campos.
     * @param id_invernadero_contacto ID de la relación
     * @param dtoInvernadero Invernadero relacionado
     * @param dtoContacto Contacto relacionado
     */
    public DtoInvernaderoContacto(Long id_invernadero_contacto, DtoInvernadero dtoInvernadero, DtoContacto dtoContacto) {
        this.id_invernadero_contacto = id_invernadero_contacto;
        this.dtoInvernadero = dtoInvernadero;
        this.dtoContacto = dtoContacto;
    }

    // Métodos getter y setter

    public Long getId_invernadero_contacto() {
        return id_invernadero_contacto;
    }

    public void setId_invernadero_contacto(Long id_invernadero_contacto) {
        this.id_invernadero_contacto = id_invernadero_contacto;
    }

    public DtoInvernadero getDtoInvernadero() {
        return dtoInvernadero;
    }

    public void setDtoInvernadero(DtoInvernadero dtoInvernadero) {
        this.dtoInvernadero = dtoInvernadero;
    }

    public DtoContacto getDtoContacto() {
        return dtoContacto;
    }

    public void setDtoContacto(DtoContacto dtoContacto) {
        this.dtoContacto = dtoContacto;
    }

    /**
     * Método toString
     * Devuelve una representación textual del objeto.
     */
    @Override
    public String toString() {
        return "DtoInvernaderoContacto{" +
                "id_invernadero_contacto=" + id_invernadero_contacto +
                ", dtoInvernadero=" + dtoInvernadero +
                ", dtoContacto=" + dtoContacto +
                '}';
    }
}
