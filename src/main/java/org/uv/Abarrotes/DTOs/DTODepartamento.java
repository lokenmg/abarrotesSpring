/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import javax.validation.constraints.NotBlank;
import org.uv.Abarrotes.modelos.Departamento;

/**
 *
 * @author yacruz
 */
public class DTODepartamento {
    private Long idDepartamento;
    @NotBlank(message = "El nombre del departamento no puede estar en blanco")
    private String nombre;
    
    public DTODepartamento() {
    }

    public DTODepartamento(Long idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }
    
    public DTODepartamento(Departamento departamento) {
        this.idDepartamento = departamento.getIdDepartamento();
        this.nombre = departamento.getNombre();
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
