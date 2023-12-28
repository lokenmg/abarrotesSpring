package org.uv.Abarrotes.DTOs;

public class DTOMEstadoPedido {
    
    private long idEstadoPedido;
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
