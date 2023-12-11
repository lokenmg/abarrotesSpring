 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marcas_id_marca_seq")
    @SequenceGenerator(name = "marcas_id_marca_seq", sequenceName = "marcas_id_marca_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private List<Producto> producto= new ArrayList<>();

    public Marca() {
    }

    public Marca(Long idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    //getters and setters
    public Long getIdMarca() {
        return this.idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public List<Producto> getProducto() {
        return this.producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto= producto;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombre=" + nombre + ", producto=" + producto + '}';
    }

}
