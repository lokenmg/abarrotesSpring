package org.uv.Abarrotes.DTOs.Entradas;

import java.math.BigDecimal;

/**
 * DTOPagoYpedido
 */
public class DTOPagoYpedido {

    private long nNota;
    private long idPedido;
    private BigDecimal pago;

    public DTOPagoYpedido() {
    }

    public DTOPagoYpedido(long nNota, long idPedido, BigDecimal pago) {
        this.nNota = nNota;
        this.idPedido = idPedido;

    }

    public long getnNota() {
        return nNota;
    }

    public void setnNota(long idPago) {
        this.nNota = idPago;
    }
    
    public long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getPago() {
        return pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }
}