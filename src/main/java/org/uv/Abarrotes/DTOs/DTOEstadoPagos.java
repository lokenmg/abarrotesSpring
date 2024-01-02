package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.EstadoPago;

public class DTOEstadoPagos {
    
    private long idEstadoPago;
    private String nombre;

    public DTOEstadoPagos() {
    }

    public DTOEstadoPagos(long idEstadoPago, String nombre) {
        this.idEstadoPago = idEstadoPago;
        this.nombre = nombre;
    }

    public DTOEstadoPagos(EstadoPago estadoPago) {
        this.idEstadoPago = estadoPago.getIdEstadoPago();
        this.nombre = estadoPago.getEstado();
    }

    public long getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(long idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String estado) {
        this.nombre = estado;
    }
}
