/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import java.sql.Date;

import org.uv.Abarrotes.modelos.DetalleReporte;

/**
 *
 * @author yacruz
 */
public class DTODetalleReporte {
    private double total;
    private Long idReporte;
    private Date fecha;
    private int idDetalleVenta;
    private long cantidad;
    private String nombreProducto;
    private String marca;
    private double precioUnitario;
    private double subtotal;

    public DTODetalleReporte() {
    }

    public DTODetalleReporte(double total, Long idReporte, Date fecha, int idDetalleVenta, long cantidad, String nombreProducto, String marca, double precioUnitario, double subtotal) {
        this.total = total;
        this.idReporte = idReporte;
        this.fecha = fecha;
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }
    
    public DTODetalleReporte(DetalleReporte detalleReporte) {
        this.total = detalleReporte.getTotal();
        this.idReporte = detalleReporte.getReporte().getIdReporte();
        this.fecha = detalleReporte.getDetalleVenta().getFecha();
        this.idDetalleVenta = detalleReporte.getDetalleVenta().getCodigo();
        this.cantidad = detalleReporte.getDetalleVenta().getCantidad();
        this.nombreProducto = detalleReporte.getDetalleVenta().getProducto().getNombre();
        this.marca = detalleReporte.getDetalleVenta().getProducto().getMarca().getNombre();
        this.precioUnitario = detalleReporte.getDetalleVenta().getProducto().getPrecio();
        this.subtotal = detalleReporte.getDetalleVenta().getSubtotal();
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
    
    
}
