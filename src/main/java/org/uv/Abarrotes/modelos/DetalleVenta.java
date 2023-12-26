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
import javax.persistence.Table;
import java.sql.Date;
import javax.persistence.FetchType;
import javax.persistence.SequenceGenerator;


@Entity
@Table(name = "Detalle_venta")
public class DetalleVenta {
    
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_venta_id_detalle_seq")
    @SequenceGenerator(name = "detalle_venta_id_detalle_seq", sequenceName = "detalle_venta_id_detalle_seq",
            initialValue = 1, allocationSize = 1)
    private Integer codigo;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "subtotal")
    private Double subtotal;
    
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_nota")
    private NotaVenta venta;

    public DetalleVenta(Integer codigo, long cantidad, Double subtotal, Date fecha, Producto producto, NotaVenta venta) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.producto = producto;
        this.venta = venta;
    }

    public DetalleVenta() {
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NotaVenta getVenta() {
        return venta;
    }

    public void setVenta(NotaVenta venta) {
        this.venta = venta;
    }
    
    
}
