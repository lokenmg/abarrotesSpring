/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;
import org.uv.Abarrotes.modelos.Empleado;
/**
 *
 * @author yacruz
 */
public class DTOEmpleadoInfo {
    
    private long idEmpleado;
    
    private String nombre;

    private String apellidos;

    private String contrasenia;
    
    private String roles;

    private Long idRol;  //línea para visualizar el idRol en el front

    
    public DTOEmpleadoInfo(){
        
    }
    
    public DTOEmpleadoInfo(long idEmpleado, String nombre, String apellidos, String contrasenia, String roles){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.roles = roles;
    }
    
    public DTOEmpleadoInfo(Empleado empleado){
        this.idEmpleado = empleado.getIdEmpleado();
        this.nombre = empleado.getNombre();
        this.apellidos = empleado.getApellidos();
        this.contrasenia = empleado.getContrasenia();
        this.roles = empleado.getRoles().getDescripcion();
    }
    
    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }   
}