/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 import java.math.BigDecimal;
import javax.persistence.OneToMany;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "Nota_ventas")
public class NotaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_ventas_numero_nota_seq")
    @SequenceGenerator(name = "nota_ventas_numero_nota_seq", sequenceName = "nota_ventas_numero_nota_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "numero_nota")
    private Long numeroNota;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_anticipo", referencedColumnName = "id_anticipo")
    private Anticipo anticipo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento;

    @OneToOne
    @JoinColumn(name = "id_detalle_pedido", unique = true, referencedColumnName = "id_detalle_pedido")
    private DetallePedido detallePedido;
    
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVenta;

    public NotaVenta(Long numeroNota, Date fecha, BigDecimal total, Anticipo anticipo, Cliente cliente, Empleado empleado, Departamento departamento, DetallePedido detallePedido, List<DetalleVenta> detalleVenta) {
        this.numeroNota = numeroNota;
        this.fecha = fecha;
        this.total = total;
        this.anticipo = anticipo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.departamento = departamento;
        this.detallePedido = detallePedido;
        this.detalleVenta = detalleVenta;
    }

    public NotaVenta() {
    }

    public Long getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Long numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Anticipo anticipo) {
        this.anticipo = anticipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    @Override
    public String toString() {
        return "NotaVenta{" + "numeroNota=" + numeroNota + ", fecha=" + fecha + ", total=" + total +
                ", anticipo=" + anticipo + ", cliente=" + cliente + ", empleado=" + empleado + 
                ", departamento=" + departamento + ", detallePedido=" + detallePedido + ", detalleVenta=" + 
                detalleVenta.size() + '}';
    }
    
    
    
}
