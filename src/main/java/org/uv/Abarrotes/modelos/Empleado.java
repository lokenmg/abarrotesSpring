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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    @Column(name = "apellidos")
    private String apellidos;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    @Column(name = "contrasenia")
    private String contrasenia;

    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico debe ser válido")
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @NotNull(message = "El rol no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol roles;
    
    @OneToMany(mappedBy = "empleado")
    private List<NotaVenta> notaVentas;

    public Empleado(Long idEmpleado, String nombre, String apellidos, String contrasenia, String correoElectronico, Rol roles, List<NotaVenta> notaVentas) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.roles = roles;
        this.notaVentas = notaVentas;
        this.correoElectronico = correoElectronico;
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
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
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