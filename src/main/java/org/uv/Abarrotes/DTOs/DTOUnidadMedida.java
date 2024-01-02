/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;
import org.uv.Abarrotes.modelos.UnidadMedida;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 *
 * @author loken
 */
public class DTOUnidadMedida {
    private long idUnidadMedida;
    private String nombre;

    public DTOUnidadMedida(long idUnidadMed, String nombre) {
        this.nombre = nombre;
    }

    public DTOUnidadMedida(UnidadMedida unidadMedida) {
        this.idUnidadMedida = unidadMedida.getIdUnidadMed();
        this.nombre = unidadMedida.getNombre();
    }

    public DTOUnidadMedida() {
    }

    @NotBlank(message = "El nombre de la unidad de medida no puede estar en blanco")
    @Size(max = 30, message = "El nombre de la unidad de medida no puede tener más de 30 caracteres")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(long id) {
        this.idUnidadMedida = id;
    }
}
