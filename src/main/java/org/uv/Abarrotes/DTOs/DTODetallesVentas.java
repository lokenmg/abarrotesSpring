package org.uv.Abarrotes.DTOs;

import javax.validation.constraints.NotNull;

public class DTODetallesVentas {
    @NotNull(message = "La cantidad no puede ser nula")
    private long cantidad;
    @NotNull(message = "El subtotal no puede ser nulo")
    private Double subtotal;
    private long codigo;
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "La existencia no puede ser nulo")
    private long existencia;    
    
    //getters y setters
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

    public long getExistencia() {
        return existencia;
    }

    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }
}
