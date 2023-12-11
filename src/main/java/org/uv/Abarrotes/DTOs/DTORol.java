/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

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

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
