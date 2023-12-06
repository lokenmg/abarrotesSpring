/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
/**
 *
 * @author loken
 */
@Entity
@Table(name = "productos")
public class Producto {
   
    @Id
    private long codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @JoinColumn(name = "id_categoria", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Categoria categoria;
    
    @JoinColumn(name = "id_marca", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Marca marca;
    
    @JoinColumn(name = "id__unidad_med", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVenta;

    public Producto(long codigo, String nombre, Categoria categoria, Marca marca, UnidadMedida unidadMedida, List<DetalleVenta> detalleVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        this.detalleVenta = detalleVenta;
    }

    public Producto() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
    
}
