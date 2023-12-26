/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.OpcionesSistema;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
