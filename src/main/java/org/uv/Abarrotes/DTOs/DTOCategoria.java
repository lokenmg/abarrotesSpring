/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.Categoria;

/**
 *
 * @author loken
 */
public class DTOCategoria {
    
    private String nombre;

    public DTOCategoria(String nombre) {
        this.nombre = nombre;
    }

    public DTOCategoria() {
    }

    public DTOCategoria(Categoria categoria) {
        this.nombre = categoria.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
