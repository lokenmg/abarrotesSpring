 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_id_categoria_seq")
    @SequenceGenerator(name = "categorias_id_categoria_seq", sequenceName = "categorias_id_categoria_seq",
             initialValue = 1, allocationSize = 1)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @NotBlank(message = "El nombre de la categoría no puede estar en blanco")   
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List <Producto> productos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
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

    @NotNull(message = "La lista de productos no puede ser nula")
    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos= productos;
    }
    
}
