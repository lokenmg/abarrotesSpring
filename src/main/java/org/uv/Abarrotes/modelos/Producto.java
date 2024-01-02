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

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
/**
 *
 * @author loken
 */
@Entity
@Table(name = "productos")
public class Producto {
   
    @Positive(message = "El codigo del producto no puede ser nulo")
    @Id
    @Column(name = "codigo")
    private long codigo;
    
    @NotBlank(message = "El nombre del producto no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
    @PositiveOrZero(message = "La existencia del producto debe ser un número positivo o cero")
    @Column(name = "existencia")
    private long existencia;
    
    @Positive(message = "El precio del producto debe ser un número positivo")
    @Column(name = "precio")
    private double precio;
    
    @NotNull(message = "La categoría del producto no puede ser nula")
    @JoinColumn(name = "id_categoria", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Categoria categoria;
    
    @NotNull(message = "La marca del producto no puede ser nula")
    @JoinColumn(name = "id_marca", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Marca marca;
    
    @NotNull(message = "La unidad de medida del producto no puede ser nula")
    @JoinColumn(name = "id_unidad_med", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVenta= new ArrayList<>();

    public Producto() {
    }

    public Producto(long codigo, String nombre, long existencia, double precio, Categoria categoria, Marca marca, UnidadMedida unidadMedida, List<DetalleVenta> detalleVenta) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.existencia = existencia;
        this.categoria = categoria;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        this.detalleVenta = detalleVenta;
        this.precio = precio;
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
    
    // getters y setters de existencia
    public long getExistencia() {
        return existencia;
    }

    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
