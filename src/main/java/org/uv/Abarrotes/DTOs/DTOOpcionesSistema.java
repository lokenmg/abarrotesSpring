/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.OpcionesSistema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author yacruz
 */
public class DTOOpcionesSistema {
    
    private Long idOpciones;
    
    private String nombre;
    
    private String tipo;
    
    public DTOOpcionesSistema() {
    }

    public DTOOpcionesSistema(Long idOpciones, String nombre, String tipo) {
        this.idOpciones = idOpciones;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public DTOOpcionesSistema(OpcionesSistema opcionesSistema) {
        this.idOpciones = opcionesSistema.getIdOpciones();
        this.nombre = opcionesSistema.getNombre();
        this.tipo = opcionesSistema.getTipo();
    }

    public Long getIdOpciones() {
        return idOpciones;
    }

    public void setIdOpciones(Long idOpciones) {
        this.idOpciones = idOpciones;
    }

    @NotBlank(message = "El nombre de la opcion no puede estar en blanco")
    @Size(max = 20, message = "El nombre de la opcion no puede tener más de 20 caracteres")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NotBlank(message = "El tipo de la opcion no puede estar en blanco")
    @Size(max = 10, message = "El tipo de la opcion no puede tener más de 10 caracteres")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
