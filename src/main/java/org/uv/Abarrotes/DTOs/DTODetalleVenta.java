/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;
import java.sql.Date;
import org.uv.Abarrotes.modelos.DetalleVenta;
/**
 *
 * @author yacruz
 */
public class DTODetalleVenta {
    private Integer codigo;
    private Double cantidad;
    private Double subtotal;
    private Date fecha;
    private Long producto; 
    private Long venta;
    
    public DTODetalleVenta() {
    }
    
    public DTODetalleVenta(Integer codigo, Double cantidad, Double subtotal, Date fecha,
            Long producto, Long venta) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.producto = producto;
        this.venta = venta;
    }
    
    public DTODetalleVenta(DetalleVenta detalleVenta) {
        this.codigo = detalleVenta.getCodigo();
//        this.cantidad = detalleVenta.getCantidad();
        this.subtotal = detalleVenta.getSubtotal();
        this.fecha = detalleVenta.getFecha();
        this.producto = detalleVenta.getProducto().getCodigo();
        this.venta = detalleVenta.getVenta().getNumeroNota();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public Long getVenta() {
        return venta;
    }

    public void setVenta(Long venta) {
        this.venta = venta;
    }
    
    
}
