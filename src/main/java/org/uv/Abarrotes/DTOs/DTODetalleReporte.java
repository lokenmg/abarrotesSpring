/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.DetalleReporte;

/**
 *
 * @author yacruz
 */
public class DTODetalleReporte {
    private double total;
    private Long idReporte;
    private int idDetalleVenta;
    
    public DTODetalleReporte() {
    }

    public DTODetalleReporte(double total, Long idReporte, int idDetalleVenta) {
        this.total = total;
        this.idReporte = idReporte;
        this.idDetalleVenta = idDetalleVenta;
    }
    
    public DTODetalleReporte(DetalleReporte detalleReporte) {
        this.total = detalleReporte.getTotal();
        this.idReporte = detalleReporte.getReporte().getIdReporte();
        this.idDetalleVenta = detalleReporte.getDetalleVenta().getCodigo();
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

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
    
}
