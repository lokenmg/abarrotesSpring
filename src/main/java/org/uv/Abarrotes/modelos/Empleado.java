 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import java.util.List;
/**
 *
 * @author loken
 */
@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleados_id_empleado_seq")
    @SequenceGenerator(name = "empleados_id_empleado_seq", sequenceName = "empleados_id_empleado_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_empleado")
    private long idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "contrasenia")
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol roles;
    
    @OneToMany(mappedBy = "empleado")
    private List<NotaVenta> notaVentas;

    public Empleado(Long idEmpleado, String nombre, String apellidos, String contrasenia, Rol roles, List<NotaVenta> notaVentas) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.roles = roles;
        this.notaVentas = notaVentas;
    }

    public Empleado() {
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }

    public List<NotaVenta> getNotaVentas() {
        return notaVentas;
    }

    public void setNotaVentas(List<NotaVenta> notaVentas) {
        this.notaVentas = notaVentas;
    }

    // Constructor que acepta un objeto Rol
    public Empleado(String nombre, Rol rol) {
        this.nombre = nombre;
        this.roles = rol;
    }   
}