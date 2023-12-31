package org.uv.Abarrotes.DTOs.Entradas;

public class DTOCrearEmpleado {
    private String nombre;
    private String apellidos;
    private String contrasenia;
    private String roles;
    private String correoElectronico;
    private long idRol;

    public DTOCrearEmpleado() {
    }

    public DTOCrearEmpleado(String nombre, String apellidos, String contrasenia, String correoElectronico, String roles, long idRol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.roles = roles;
        this.idRol = idRol;
        this.correoElectronico = correoElectronico;
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

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

}
