package org.uv.Abarrotes.DTOs.Entradas;

public class DTOCrearEmpleado {
    private String nombre;
    private String apellidos;
    private String contrasenia;
    private long idRol;

    public DTOCrearEmpleado() {
    }

    public DTOCrearEmpleado(String nombre, String apellidos, String contrasenia, long idRol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.idRol = idRol;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public long getIdRol() {
        return this.idRol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

}
