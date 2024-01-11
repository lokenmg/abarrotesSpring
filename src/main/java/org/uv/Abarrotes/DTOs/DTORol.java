/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.uv.Abarrotes.modelos.Rol;

/**
 *
 * @author yacruz
 */
public class DTORol {
    
    private long idRol;
    
    private String cve;
    
    private String descripcion;
    
    public DTORol(){
        
    }
    
    public DTORol(long idRol, String cve, String descripcion){
        this.idRol = idRol;
        this.cve = cve;
        this.descripcion = descripcion;
        
    }
    
    public DTORol(Rol rol){
        this.idRol = rol.getIdRol();
        this.cve = rol.getCve();
        this.descripcion =rol.getDescripcion();
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    @NotBlank(message = "El cve del rol no puede estar en blanco")
    @Size(max = 20, message = "El cve del rol no puede tener más de 20 caracteres")
    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @NotBlank(message = "La descripcion del rol no puede estar en blanco")
    @Size(max = 60, message = "La descripcion del rol no puede tener más de 60 caracteres")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
