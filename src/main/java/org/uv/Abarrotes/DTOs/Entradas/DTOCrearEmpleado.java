package org.uv.Abarrotes.DTOs.Entradas;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DTOCrearEmpleado {
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    private String apellidos;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String contrasenia;

    @Email(message = "El correo electrónico debe ser válido")
    private String correoElectronico;

    @NotNull(message = "El ID del rol no puede ser nulo")
    private long idRol;

    public DTOCrearEmpleado() {
    }

    public DTOCrearEmpleado(String nombre, String apellidos, String contrasenia, String correoElectronico, long idRol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
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

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

}
