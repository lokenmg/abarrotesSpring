/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.List;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_rol_seq")
    @SequenceGenerator(name = "roles_id_rol_seq", sequenceName = "roles_id_rol_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "cve")
    private String cve;

    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "roles")
    List<OpcionesRol> opcionesRoles;
    
    @OneToMany(mappedBy = "roles")
    List<Empleado> usuarios;

    public Rol(Long idRol, String cve, String descripcion, List<OpcionesRol> opcionesRoles, List<Empleado> usuarios) {
        this.idRol = idRol;
        this.cve = cve;
        this.descripcion = descripcion;
        this.opcionesRoles = opcionesRoles;
        this.usuarios = usuarios;
    }

    public Rol() {
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
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

    public List<OpcionesRol> getOpcionesRoles() {
        return opcionesRoles;
    }

    public void setOpcionesRoles(List<OpcionesRol> opcionesRoles) {
        this.opcionesRoles = opcionesRoles;
    }

    public List<Empleado> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Empleado> usuarios) {
        this.usuarios = usuarios;
    }


    public String getNombre() {
        // En este ejemplo, simplemente devolvemos la descripción como nombre
        return this.descripcion;
    }

    //Metodo para Agregar Empleados
    public Rol(Long idRol,String cve, String descripcion) {
        this.idRol=idRol;
        this.cve = cve;
        this.descripcion = descripcion;
    }  
}