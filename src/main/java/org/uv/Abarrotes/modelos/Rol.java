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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_id_rol_seq")
    @SequenceGenerator(name = "rol_id_rol_seq", sequenceName = "rol_id_rol_seq",
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

    
}
