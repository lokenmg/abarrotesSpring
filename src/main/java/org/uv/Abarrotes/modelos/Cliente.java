/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *
 * @author loken
 */
@Entity
@Table ( name = "Clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_id_cliente_seq")
    @SequenceGenerator(name = "clientes_id_cliente_seq", sequenceName = "clientes_id_cliente_seq",
             initialValue = 1, allocationSize = 1)
    @Column(name = "id_cliente")
    private Long idCliente;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    @Column(name = "apellidos")
    private String apellidos;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    @Column(name = "telefono")
    private String telefono;

    @NotBlank(message = "La dirección no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;
    
    @OneToMany(mappedBy = "cliente")
    private List<NotaVenta> notaVentas;

    public Cliente(Long idCliente, String nombre, String apellidos, String telefono, String direccion, List<NotaVenta> notaVentas) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.notaVentas = notaVentas;
    }
    
    public Cliente(){
        
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
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

    public List<NotaVenta> getNotaVentas() {
        return notaVentas;
    }

    public void setNotaVentas(List<NotaVenta> notaVentas) {
        this.notaVentas = notaVentas;
    }
    
}
