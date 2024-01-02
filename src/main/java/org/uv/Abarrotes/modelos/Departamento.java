/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamentos_id_departamento_seq")
    @SequenceGenerator(name = "departamentos_id_departamento_seq", sequenceName = "departamentos_id_departamento_seq",
             initialValue = 1, allocationSize = 1)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @NotBlank(message = "El nombre del departamento no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "departamento")
    private List<NotaVenta> notaVentas;

    public Departamento(Long idDepartamento, String nombre, List<NotaVenta> notaVentas) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.notaVentas = notaVentas;
    }

    public Departamento() {
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<NotaVenta> getNotaVentas() {
        return notaVentas;
    }

    public void setNotaVentas(List<NotaVenta> notaVentas) {
        this.notaVentas = notaVentas;
    }
    
    
}
