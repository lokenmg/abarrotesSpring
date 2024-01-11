/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;
import java.sql.Date;
import javax.validation.constraints.NotNull;
import org.uv.Abarrotes.modelos.DetalleVenta;
/**
 *
 * @author yacruz
 */
public class DTODetalleVenta {
    private Integer codigo;
    @NotNull(message = "La cantidad no puede ser nula")
    private long cantidad;

    @NotNull(message = "El subtotal no puede ser nulo")
    private Double subtotal;

    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;

    @NotNull(message = "El código de producto no puede ser nulo")
    private Long producto;

    @NotNull(message = "El número de venta no puede ser nulo")
    private Long venta;
    
    public DTODetalleVenta() {
    }
    
    public DTODetalleVenta(Integer codigo, long cantidad, Double subtotal, Date fecha,
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
        this.cantidad = detalleVenta.getCantidad();
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

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
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
