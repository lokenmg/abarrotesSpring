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

    private String correoElectronico;
    
    private String roles;

    private Long idRol;  //línea para visualizar el idRol en el front

    
    public DTOEmpleadoInfo(){
        
    }
    
    public DTOEmpleadoInfo(long idEmpleado, String nombre, String apellidos, Long idRol, String correoElectronico, String roles){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.roles = roles;
        this.correoElectronico = correoElectronico;
        this.idRol = idRol;
    }
    
    public DTOEmpleadoInfo(Empleado empleado){
        this.idEmpleado = empleado.getIdEmpleado();
        this.nombre = empleado.getNombre();
        this.apellidos = empleado.getApellidos();
        this.roles = empleado.getRoles().getDescripcion();
        this.correoElectronico = empleado.getCorreoElectronico();
        this.idRol = empleado.getRoles().getIdRol();
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
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