/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.Marca;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 *
 * @author loken
 */
public class DTOmarca {
    private Long idMarca;
    private String nombre;

    public DTOmarca() {
    }

    public DTOmarca(Marca marca) {
        this.idMarca = marca.getIdMarca();
        this.nombre = marca.getNombre();
    }
    @NotBlank(message = "El nombre de la marca no puede estar en blanco")
    @Size(max = 40, message = "El nombre de la marca no puede tener más de 40 caracteres")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //get y set de idMarca

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }
}
