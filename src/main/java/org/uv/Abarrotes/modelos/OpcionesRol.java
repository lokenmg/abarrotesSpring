 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Opciones_roles")
public class OpcionesRol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opciones_roles_id_opc_rol_seq")
    @SequenceGenerator(name = "opciones_roles_id_opc_rol_seq", sequenceName = "opciones_roles_id_opc_rol_seq",
            initialValue = 1, allocationSize = 1)
    private Long idOpcRol;

    @ManyToOne
    @JoinColumn(name = "id_opciones", referencedColumnName = "id_opciones")
    private OpcionesSistema opcionesSistema;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol roles;

    public OpcionesRol(Long idOpcRol, OpcionesSistema opcionesSistema, Rol roles) {
        this.idOpcRol = idOpcRol;
        this.opcionesSistema = opcionesSistema;
        this.roles = roles;
    }

    public OpcionesRol() {
    }

    public Long getIdOpcRol() {
        return idOpcRol;
    }

    public void setIdOpcRol(Long idOpcRol) {
        this.idOpcRol = idOpcRol;
    }

    public OpcionesSistema getOpcionesSistema() {
        return opcionesSistema;
    }

    public void setOpcionesSistema(OpcionesSistema opcionesSistema) {
        this.opcionesSistema = opcionesSistema;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }
    
}
