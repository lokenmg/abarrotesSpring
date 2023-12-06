/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Opciones_sistema")
public class OpcionesSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opciones_sistema_id_opciones_seq")
    @SequenceGenerator(name = "opciones_sistema_id_opciones_seq", sequenceName = "opciones_sistema_id_opciones_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_opciones")
    private Long idOpciones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(mappedBy = "opcionesSistema")    
    private List<OpcionesRol> opcionesRoles;

    public OpcionesSistema(Long idOpciones, String nombre, String tipo, List<OpcionesRol> opcionesRoles) {
        this.idOpciones = idOpciones;
        this.nombre = nombre;
        this.tipo = tipo;
        this.opcionesRoles = opcionesRoles;
    }

    public OpcionesSistema() {
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

    public List<OpcionesRol> getOpcionesRoles() {
        return opcionesRoles;
    }

    public void setOpcionesRoles(List<OpcionesRol> opcionesRoles) {
        this.opcionesRoles = opcionesRoles;
    }
    
    
    
}
