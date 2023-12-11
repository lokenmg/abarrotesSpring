 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.OneToMany;
import java.util.List;
/**
 *
 * @author loken
 */
@Entity
@Table(name = "Anticipos")
public class Anticipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aniticipos_id_anticipo_seq")
    @SequenceGenerator(name = "aniticipos_id_anticipo_seq", sequenceName = "aniticipos_id_anticipo_seq",
                allocationSize = 1, initialValue = 1)
    @Column(name = "id_anticipo")
    private Long idAnticipo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "resto")
    private BigDecimal resto;

    @ManyToOne
    @JoinColumn(name = "id_estado_pago")
    private EstadoPago estadoPago;
    
    @OneToMany(mappedBy = "anticipo")
    private List <NotaVenta> notaVenta;

    public Anticipo(Long idAnticipo, Date fecha, BigDecimal monto, BigDecimal resto, EstadoPago estadoPago, List<NotaVenta> notaVenta) {
        this.idAnticipo = idAnticipo;
        this.fecha = fecha;
        this.monto = monto;
        this.resto = resto;
        this.estadoPago = estadoPago;
        this.notaVenta = notaVenta;
    }

    public Anticipo() {
    }

    public Long getIdAnticipo() {
        return idAnticipo;
    }

    public void setIdAnticipo(Long idAnticipo) {
        this.idAnticipo = idAnticipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getResto() {
        return resto;
    }

    public void setResto(BigDecimal resto) {
        this.resto = resto;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public List <NotaVenta> getNotaVenta() {
        return notaVenta;
    }

    public void setNotaVenta(List <NotaVenta> notaVenta) {
        this.notaVenta = notaVenta;
    }
    
    
}
