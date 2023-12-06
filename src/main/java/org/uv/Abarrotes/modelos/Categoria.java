 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.List;
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_id_categoria_seq")
    @SequenceGenerator(name = "categorias_id_categoria_seq", sequenceName = "categorias_id_categoria_seq",
             initialValue = 1, allocationSize = 1)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "categoria")
    private List <Producto> productos;

    public Categoria() {
    }

    public Categoria(Long idCategoria, String nombre, List<Producto> productos) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.productos = productos;
    }

    public Long getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos= productos;
    }
    
}
