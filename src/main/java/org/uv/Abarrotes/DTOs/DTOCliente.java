/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.uv.Abarrotes.modelos.Cliente;

/**
 *
 * @author yacruz
 */
public class DTOCliente {
    private long idCliente;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    private String apellidos;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    @NotBlank(message = "La dirección no puede estar en blanco")
    private String direccion;
    
    public DTOCliente(){
        
    }

    public DTOCliente(long idCliente, String nombre, String apellidos, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public DTOCliente(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nombre = cliente.getNombre();
        this.apellidos = cliente.getApellidos();
        this.telefono = cliente.getTelefono();
        this.direccion = cliente.getDireccion();
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
