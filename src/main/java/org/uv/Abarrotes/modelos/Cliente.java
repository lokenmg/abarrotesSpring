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
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column (name = "direccion")
    private String direccion;
    
    @OneToMany(mappedBy = "cliente")
    private List<NotaVenta> notaVentas;
}
