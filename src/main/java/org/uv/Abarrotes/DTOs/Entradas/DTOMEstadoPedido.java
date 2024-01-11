package org.uv.Abarrotes.DTOs.Entradas;

import javax.validation.constraints.NotNull;

public class DTOMEstadoPedido {
    
    private long idEstadoPedido;
    @NotNull(message = "La nota no puede ser nula")
    private long nNota; 

    public DTOMEstadoPedido() {
    }

    public DTOMEstadoPedido(long idEstadoPedido, long nNota) {
        this.idEstadoPedido = idEstadoPedido;
        this.nNota = nNota;
    }

    public long getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(long idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public long getnNota() {
        return nNota;
    }

    public void setnNota(long nNota) {
        this.nNota = nNota;
    }
}
