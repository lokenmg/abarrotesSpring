package org.uv.Abarrotes.DTOs.Entradas;

import java.math.BigDecimal;

public class DTOPago {

    private long nNota;
    private BigDecimal pago;

    public DTOPago() {
    }

    public DTOPago(long nNota, BigDecimal pago) {
        this.nNota = nNota;
        this.pago = pago;
    }

    public BigDecimal getPago() {
        return pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }

    public long getnNota() {
        return nNota;
    }

    public void setnNota(long nNota) {
        this.nNota = nNota;
    }
}
