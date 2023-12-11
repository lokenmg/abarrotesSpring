/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.Marca;

/**
 *
 * @author loken
 */
public class DTOmarca {
    
    private String nombre;

    public DTOmarca(String nombre) {
        this.nombre = nombre;
    }

    public DTOmarca() {
    }

    public DTOmarca(Marca marca) {
        this.nombre = marca.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
