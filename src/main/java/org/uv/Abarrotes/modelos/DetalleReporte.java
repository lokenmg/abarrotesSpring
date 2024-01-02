 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author loken
 */
@Entity
@Table(name = "detalle_reporte")
public class DetalleReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_reporte_id_detalle_rep_seq")
    @SequenceGenerator(name = "detalle_reporte_id_detalle_rep_seq", sequenceName = "detalle_reporte_id_detalle_rep_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_detalle_rep")
    private Long idDetalleReporte;

    @Min(value = 0, message = "El total debe ser mayor o igual a cero")
    @Column(name = "total")
    private double total;

    @NotNull(message = "El reporte no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_reporte", nullable = false)
    private Reporte reporte;

    @NotNull(message = "El detalleVenta no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_detalle_venta", nullable = false)
    private DetalleVenta detalleVenta;

    public DetalleReporte() {
    }

    public DetalleReporte(Long idDetalleReporte, double total, Reporte reporte, DetalleVenta detalleVenta) {
        this.idDetalleReporte = idDetalleReporte;
        this.total = total;
        this.reporte = reporte;
        this.detalleVenta = detalleVenta;
    }

    public Long getIdDetalleReporte() {
        return this.idDetalleReporte;
    }

    public void setIdDetalleReporte(Long idDetalleReporte) {
        this.idDetalleReporte = idDetalleReporte;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Reporte getReporte() {
        return this.reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public DetalleVenta getDetalleVenta() {
        return this.detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
}
