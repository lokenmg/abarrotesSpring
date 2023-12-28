/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.OpcionesRol;

/**
 *
 * @author yacruz
 */
public class DTOOpcionesRol {
    private long idOpcionRol;
    
    private long opcionesSistema;
    
    private String roles;
    
    public DTOOpcionesRol(){
        
    }
    
    public DTOOpcionesRol(long idOpcionRol, long opcionesSistema, String roles){
        this.idOpcionRol = idOpcionRol;
        this.opcionesSistema = opcionesSistema;
        this.roles = roles;
    }
    
    public DTOOpcionesRol(OpcionesRol opcionesRol){
        this.idOpcionRol = opcionesRol.getIdOpcRol();
        this.opcionesSistema = opcionesRol.getOpcionesSistema().getIdOpciones();
        this.roles = opcionesRol.getRoles().getDescripcion();
    }

    public long getIdOpcionRol() {
        return idOpcionRol;
    }

    public void setIdOpcionRol(long idOpcionRol) {
        this.idOpcionRol = idOpcionRol;
    }

    public long getOpcionesSistema() {
        return opcionesSistema;
    }

    public void setOpcionesSistema(long opcionesSistema) {
        this.opcionesSistema = opcionesSistema;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
}
